package com.pe.medical.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pe.medical.constants.ApplicationConstants;
import com.pe.medical.domain.AccessRequestRecords;
import com.pe.medical.domain.User;
import com.pe.medical.helper.DateTimeHelper;
import com.pe.medical.helper.GenericUtil;
import com.pe.medical.helper.SecurityContextHelper;
import com.pe.medical.repository.AccessRequestRecordsRepository;
import com.pe.medical.repository.UserRepository;

@Service
public class AccessRequestServiceImpl implements AccessRequestService {

	private static Logger logger = LoggerFactory.getLogger(AccessRequestServiceImpl.class);
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccessRequestRecordsRepository accessRequestRecordsRepository;
	
	@Autowired
	SecurityContextHelper securityContextHelper;
	
	@Autowired
	GenericUtil genericUtil;
	
	@Autowired
	DispatcherService dispatcherService;
	/**
	 * Creates an entry in the accessRequestRecords with an accessCode. User would approve
	 * to this request by providing this accessCode and then only a person can view the
	 * requested resource.
	 */
	public boolean placeAccessRequest(String userId) throws Exception {

		Optional<User> optionalUser = userRepository.findById(Long.parseLong(userId));
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			User requester = securityContextHelper.getCurrentUser();
			AccessRequestRecords accessRequestRecords = new AccessRequestRecords();
			String accessCode = String.valueOf(genericUtil.generateAccessCode());
			accessRequestRecords.setAccessCode(accessCode);
			accessRequestRecords.setUser(user);
			accessRequestRecords.setRequestedBy(requester);
			accessRequestRecords.setAccessCodeGeneratedAt(DateTimeHelper.getCurrentDate());
			accessRequestRecords.setCreatedDate(DateTimeHelper.getCurrentDate());
			accessRequestRecords.setStatus(ApplicationConstants.GENERATED);
			accessRequestRecords.setAccessCodeTtl(ApplicationConstants.ACCESS_CODE_TTL);
			
			//create the record in DB for verification purpose.
			accessRequestRecordsRepository.save(accessRequestRecords);
			// send to user via 2FA
			dispatcherService.dispatchAccessCodeToUser(user, requester, accessCode);
			return true;
		} else {
			throw new UsernameNotFoundException("User for id " + userId + ", doesnt exist.");
		}
	}
	
	/**
	 * Verifies whether a given accessCode is valid (by comparing equality as well as TTL)
	 */
	public boolean verifyAccessCode(String userId, String requesterId, String accessCode) {
		logger.info("Verifying accessCode for userId: " + userId + "\n RequestedBy : " + requesterId + " \n accessCode:"
				+ accessCode);
		
		boolean isVerified = false;
		
		AccessRequestRecords accessRequestRecords = accessRequestRecordsRepository
				.getAccessRequestRecordsByRequesterIdAndUserId(Long.parseLong(userId), Long.parseLong(requesterId),
						accessCode);
		
		if (accessRequestRecords != null) {
			Date validUntill = new Date(accessRequestRecords.getAccessCodeGeneratedAt().getTime()
					+ accessRequestRecords.getAccessCodeTtl());
			
			if(new Date(System.currentTimeMillis()).before(validUntill)) {
				
				accessRequestRecords.setStatus(ApplicationConstants.USED);
				isVerified = true;
			}else {
				
				accessRequestRecords.setStatus(ApplicationConstants.EXPIRED);
			}
			//update the accessCode status
			accessRequestRecordsRepository.save(accessRequestRecords);
			return  isVerified;
		}
		return false;
	}

}

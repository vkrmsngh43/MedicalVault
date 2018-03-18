## Creating a User
```
Sample Request :
	EndPoint : localhost:8080/auth/signup
	Sample Request : 
	{
	"username":"sampleuser",
	"password":"secret",
	"firstName":"Dr. Dave",
	"lastName" :"Matthew",
	"phoneNumber":"8291326130",
	"userType":"Doctor",
	"email":"xyz@abc.com"
	}
```

## Login a user
```
End Point : localhost:8080/auth

Sample Request :
	{
	"username":"Monu",
	"password":"1234"
	}
Sample Response :

	{
    "statusCode": 1,
    "message": "success",
    "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJNb251IiwiY3JlYXRlZCI6MTUyMTM5MTgzNDAwNSwiZXhwIjoyMzg1MzkxODM0fQ.FxNpL9RV84JqysLptwh7Wj4vy7L38zWziYpHm6teZTcHlgcicKhOXJmeF6ckz9QS-JziSRQdeiTWxD56qfbHQw"
}
```

## Placing an access request to view a user's record
```
End point : localhost:8080/userrecords/request-access/user/{userId}

Sample Response : Access Request has been placed
```

## Getting Access to view the user's Prescription Record
```
End Point : localhost:8080/prescriptionrecords/find/user/{userId}/{accessCode}
Sample Response :
	{
    "statusCode": 1,
    "message": "success",
    "prescriptionRecords": [
        {
            "userId": "10102",
            "username": "Example Singh",
            "prescribedBy": "vikramsingh",
            "medicalCondition": "Pneumonia",
            "allergies": "None",
            "medicDuration": 3,
            "prescriptions": "Pneumonia Cure",
            "prescriptionNotes": "Take until cured",
            "createdAt": null
        }
     ]
	}
```

## Getting access to view the user's Medical Records
```
End Point : localhost:8080/medicalrecords/find/{userId}/accesscode/{accessCode}
```
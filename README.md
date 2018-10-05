# neuro-console-backend
Created Rest Services and their respective urls are as follows -

1. User 
a. Post Rest Service - For CREATION OF USER
            * URL =>http://localhost:8080/user
           * REQUEST BODY => {
						"name" : "Tushar Patil", 
						"gender" : "male",
						"dob" : "2000-01-31",
						"phone" : "1234567890",
						"email" : "abc@abc.com",
						"empid": 6,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\tushar_patil.png",
						"picname": "tushar_patil.png",
						"pictemplate": null
					}
           * OUTPUT => {
						"id": 0,
						"name": "Tushar Patil",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\tushar_patil.png",
						"picname": "tushar_patil.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh…...."
					}
b. Get Rest Service - For GETTING USER DATA
i> findByName
           * URL => http://localhost:8080/user/name/Tushar%20Patil
           * REQUEST BODY => No body needed.
           * OUTPUT => {
						"id": 10,
						"name": "Tushar Patil",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\tushar_patil.png",
						"picname": "tushar_patil.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}

					
ii> findById			
URL =>  http://localhost:8080/user/id/10
 REQUEST BODY => No body needed.
OUTPUT => {
						"id": 10,
						"name": "Tushar Patil",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\tushar_patil.png",
						"picname": "tushar_patil.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}
					

iii> findByEmail
URL =>  http://localhost:8080/user/email/abc@abc.com
REQUEST BODY => No body needed.
OUTPUT => {
						"id": 10,
						"name": "Tushar Patil",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\tushar_patil.png",
						"picname": "tushar_patil.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}

					
iv> findByPhone
URL =>  http://localhost:8080/user/phone/1234567890
REQUEST BODY => No body needed.
OUTPUT => {
						"id": 10,
						"name": "Tushar Patil",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\tushar_patil.png",
						"picname": "tushar_patil.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}

v> findAll
URL =>  http://localhost:8080/user/users
REQUEST BODY => No body needed.
OUTPUT => [
						{"id":1,
						"name":"Sridevi Shah",
						"gender":"Female",
						"dob":"2018-09-10T22:31:27.000+0000",
						"phone":"9812654378",
						"email":"sri@gmail.com",
						"empid":2,
						"department":"Software Developer",
						"misc":"BBBBBBB",
						"picurl":"D:\\neuroImgDB\\subject004.png",
						"picname":"subject004.png",
						"pictemplate":"iVBORw0KGgoAA..."},
						{"id":3,
						"name":"RuchaPuttewar",
						"gender":"Female",
						"dob":"2018-09-10T22:34:38.000+0000",
						"phone":"9812654738",
						"email":"rucha@gmail.com",
						"empid":1,
						"department":"Marketing",
						"misc":"CCCCCCCC",
						"picurl":"D:\\neuroImgDB\\subject002.png",
						"picname":"subject002.png",
						"pictemplate":"iVBORw0KGgoAA..."},
						{"id":4,
						"name":"Trupti Puttewar",
						"gender":"Female",
						"dob":"2018-09-10T22:36:15.000+0000",
						"phone":"9814562783",
						"email":"trupti@gmail.com",
						"empid":3,
						"department":"Software Engg",
						"misc":"AAAAA",
						"picurl":"D:\\neuroImgDB\\subject005.jpg",
						"picname":"subject005.png",
						"pictemplate":"/9j/4AA..."},
						{"id":5,
						"name":"Sandeep Bamane",
						"gender":"Male",
						"dob":"1983-09-22T18:30:00.000+0000",
						"phone":"9815554378",
						"email":"sandeep@gmail.com",
						"empid":4,
						"department":"Software Developer",
						"misc":"ZZZZZ",
						"picurl":"D:\\neuroImgDB\\sandeep_bamane.png",
						"picname":"sandeep_bamane.png",
						"pictemplate":"iVBORw0KGgoAA..."},
						{"id":6,
						"name":"Trupti Xyz",
						"gender":"Female",
						"dob":"1982-09-22T18:30:00.000+0000",
						"phone":"9813354378",
						"email":"trupti_abc@gmail.com",
						"empid":5,
						"department":"Software Developer",
						"misc":"YYYYYY",
						"picurl":"D:\\neuroImgDB\\trupti_abc.png",
						"picname":"trupti_abc.png",
						"pictemplate":"iVBORw0KGgoAA..."},
						{"id":10,
						"name":"Tushar Patil",
						"gender":"male",
						"dob":"2000-01-31T00:00:00.000+0000",
						"phone":"1234567890",
						"email":"abc@abc.com",
						"empid":0,
						"department":"HR",
						"misc":"KKKKKKKKKK",
						"picurl":"D:\\neuroImgDB\\tushar_patil.png",
						"picname":"tushar_patil.png",
						"pictemplate":"iVBORw0KGgoAA..."}
						]

c. Update Rest Service - For UPDATING USER DATA
URL => http://localhost:8080/user/update/Tushar%20Patil
REQUEST BODY => { "empid": 6 }
OUTPUT => {
						"id": 10,
						"name": "Tushar Patil",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 6,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\tushar_patil.png",
						"picname": "tushar_patil.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}

d. Delete Rest Service - For REMOVING USER DATA
URL =>  http://localhost:8080/user/id/10
REQUEST BODY => No body needed.
OUTPUT =>  Deleted id = 10 Successfully


	



2. Camera 
a. Post Rest Service - For CREATING/ADDING NEW CAMERA DATA
URL => http://localhost:8080/camera
REQUEST BODY => {
				  	"name" : "Integrated Camera", 
					"location" : "System",
					"type": "IN"
				}
OUTPUT => {
				"id": 3,
				"name": "Integrated Camera",
				"location": "System",
				"type": "IN"
			}
	
b. Get Rest Service - For GETTING CAMERA DATA
	
i> findByName
URL => http://localhost:8080/camera/name/webcam
REQUEST BODY => No body needed.
OUTPUT => {
    			    "id": 2,
    "name": "Webcam",
    "location": "System",
    "type": "OUT"
}

					
ii> findById			
URL => http://localhost:8080/camera/id/1
REQUEST BODY => No body needed.
OUTPUT => {
    "id": 2,
    "name": "Webcam",
    "location": "External",
    "type": "OUT"
}
					

iii> findALL
URL => http://localhost:8080/camera/cameras
REQUEST BODY => No body needed.
OUTPUT =>[
    {
        "id": 2,
        "name": "Webcam",
        "location": "External",
        "type": "OUT"
    },
    {
        "id": 3,
        "name": "Integrated Camera",
        "location": "System",
        "type": "IN"
    }
]


c. Update Rest Service - For UPDATING CAMERA DATA
URL => http://localhost:8080/camera/update/name/webcam
REQUEST BODY => {
					"location" : "External"
				}
OUTPUT => {
				"id": 2,
				"name": "Webcam",
				"location": "External",
				"type": "OUT"
		}


d. Delete Rest Service - For  REMOVING CAMERA DATA
URL =>  http://localhost:8080/camera/delete/id/1
REQUEST BODY => No body needed.
OUTPUT => Deleted id = 1 Successfully
	
	







3. History/Track 

a. Post Rest Service - For CREATING/ADDING HISTORY DATA
THIS IS DONE FROM SURVEILLANCE APP
	
b. Get Rest Service - For GETTING HISTORY DATA
i> findByCameratype
URL => http://localhost:8080/history/cameratype/out
REQUEST BODY => No body needed.
OUTPUT => [{"id":1,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-09-25T18:30:00.000+0000"},{"id":2,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-09-26T18:30:00.000+0000"},{"id":3,"cameratype":"OUT","name":"anonymous02.png","timein":null,"timeout":"2018-09-26T18:30:00.000+0000"},{"id":4,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-10-02T18:30:00.000+0000"},{"id":5,"cameratype":"OUT","name":"anonymous02.png","timein":null,"timeout":"2018-10-02T18:30:00.000+0000"},{"id":6,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-10-03T18:30:00.000+0000"}]


					
ii> findById			
URL => http://localhost:8080/history/id/2
REQUEST BODY => No body needed.
OUTPUT => {
    "id": 2,
    "cameratype": "OUT",
    "name": "anonymous01.png",
    "timein": null,
    "timeout": "2018-09-26T18:30:00.000+0000"
}

iii> findByName
URL => http://localhost:8080/history/name/anonymous01.png
REQUEST BODY => No body needed.
OUTPUT => [{"id":1,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-09-25T18:30:00.000+0000"},{"id":2,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-09-26T18:30:00.000+0000"},{"id":4,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-10-02T18:30:00.000+0000"},{"id":6,"cameratype":"OUT","name":"anonymous01.png","timein":null,"timeout":"2018-10-03T18:30:00.000+0000"}]

					

iii> findALL
URL => http://localhost:8080/history/histories
REQUEST BODY => No body needed.
OUTPUT =>[
    {
        "id": 1,
        "cameratype": "OUT",
        "name": "anonymous01.png",
        "timein": null,
        "timeout": "2018-09-25T18:30:00.000+0000"
    },
    {
        "id": 2,
        "cameratype": "OUT",
        "name": "anonymous01.png",
        "timein": null,
        "timeout": "2018-09-26T18:30:00.000+0000"
    },
    {
        "id": 3,
        "cameratype": "OUT",
        "name": "anonymous02.png",
        "timein": null,
        "timeout": "2018-09-26T18:30:00.000+0000"
    },
    {
        "id": 4,
        "cameratype": "OUT",
        "name": "anonymous01.png",
        "timein": null,
        "timeout": "2018-10-02T18:30:00.000+0000"
    },
    {
        "id": 5,
        "cameratype": "OUT",
        "name": "anonymous02.png",
        "timein": null,
        "timeout": "2018-10-02T18:30:00.000+0000"
    },
    {
        "id": 6,
        "cameratype": "OUT",
        "name": "anonymous01.png",
        "timein": null,
        "timeout": "2018-10-03T18:30:00.000+0000"
    }
]



c. Update Rest Service -For  UPDATING HISTORY DATA
URL =>  http://localhost:8080/history/update/name/anonymous01.png
REQUEST BODY => No body needed.
OUTPUT => Deleted id = 1 Successfully

	d. Delete Rest Service - For REMOVING HISTORY DATA
URL =>  http://localhost:8080/history/delete/id/6
REQUEST BODY => No body needed.
OUTPUT => Deleted id = 6 Successfully


	
4. UnIdentified Person
	a. Post Rest Service - For CREATING/ADDING UNIDENTIFIED PERSON DATA
	b. Get Rest Service - For GETTING UNIDENTIFIED PERSON DATA
	c. Update Rest Service -For  UPDATING UNIDENTIFIED PERSON DATA
	d. Delete Rest Service - For REMOVING UNIDENTIFIED PERSON DATA
	
5. Notification 
	a. Post Rest Service - For CREATING/ADDING NOTIFICATION DATA
	b. Get Rest Service - For GETTING NOTIFICATION DATA
	c. Update Rest Service -For  UPDATING NOTIFICATION DATA
	d. Delete Rest Service - For REMOVING NOTIFICATION DATA

	
6. LoginDetails (for login)
    a. Post Rest Service - For CREATING/ADDING LOGINDETAILS DATA
URL => http://localhost:8080/login
REQUEST BODY => {
				  	"username" : "admin", 
					"password" : "admin123",
					"role": "ADMIN"
				}
OUTPUT => {
    "id": 3,
 		   "username": "admin",
   		   "password": "admin123",
  		  "role": "ADMIN"
}

	
b. Get Rest Service - For GETTING LOGINDETAILS DATA
	
i> findByName
URL => http://localhost:8080/login/username/admin
REQUEST BODY => No body needed.
OUTPUT => {"id":3,"username":"admin","password":"admin123","role":"ADMIN"}


					
ii> findById			
URL => http://localhost:8080/login/id/1
REQUEST BODY => No body needed.
OUTPUT => {"id":1,"username":"test","password":"test123","role":"USER"}

					

iii> findALL
URL => http://localhost:8080/login/logindetails
REQUEST BODY => No body needed.
OUTPUT =>[{"id":1,"username":"test","password":"test123","role":"USER"},{"id":2,"username":"neuro","password":"test123","role":"USER"},{"id":3,"username":"admin","password":"admin123","role":"ADMIN"}]

iv> findByNameAndRole
URL => http://localhost:8080/login/nameandrole?username=neuro&role=user
REQUEST BODY => No body needed.
OUTPUT =>{"id":2,"username":"neuro","password":"test123","role":"USER"}




c. Update Rest Service -For  UPDATING LOGINDETAILS DATA
URL => http://localhost:8080/login/update/username/neuro 
REQUEST BODY => {
						"password" : "neuro123"
				}
OUTPUT => {
				"id": 2,
  				 "username": "neuro",
   				 "password": "neuro123",
   				 "role": "USER"

		}



d. Delete Rest Service - For REMOVING LOGINDETAILS DATA
i> deleteById

URL =>  http://localhost:8080/login/delete/id/2
REQUEST BODY => No body needed.
OUTPUT => Deleted id = 2 Successfully
i> deleteByName
URL =>  http://localhost:8080/login/delete/username/neuro
REQUEST BODY => No body needed.
OUTPUT => Deleted username = neuro Successfully


	
7. First IN and Last OUT TIMINGS of Employee 
	a. By Date Rest Service - To get data of employee for the date
	b. By Month Rest Service - To get data of employee for the Month
	c. Between Date Range Rest Service - To get data of employee Between the dates
	


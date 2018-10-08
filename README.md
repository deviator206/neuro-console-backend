# neuro-console-backend
Created Rest Services and their respective urls are as follows -

1. User 
a. Post Rest Service - For CREATION OF USER
            * URL =>http://localhost:8080/user
           * REQUEST BODY => {
						"name" : "xyz abc", 
						"gender" : "male",
						"dob" : "2000-01-31",
						"phone" : "1234567890",
						"email" : "abc@abc.com",
						"empid": 6,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\xyz_abc.png",
						"picname": "xyz_abc.png",
						"pictemplate": null
					}
           * OUTPUT => {
						"id": 0,
						"name": "xyz abc",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\xyz_abc.png",
						"picname": "xyz_abc.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh…...."
					}
b. Get Rest Service - For GETTING USER DATA
i> findByName
           * URL => http://localhost:8080/user/name/xyz%20abc
           * REQUEST BODY => No body needed.
           * OUTPUT => {
						"id": 10,
						"name": "xyz abc",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\xyz_abc.png",
						"picname": "xyz_abc.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}

					
ii> findById			
URL =>  http://localhost:8080/user/id/10
 REQUEST BODY => No body needed.
OUTPUT => {
						"id": 10,
						"name": "xyz abc",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\xyz_abc.png",
						"picname": "xyz_abc.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}
					

iii> findByEmail
URL =>  http://localhost:8080/user/email/abc@abc.com
REQUEST BODY => No body needed.
OUTPUT => {
						"id": 10,
						"name": "xyz abc",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\xyz_abc.png",
						"picname": "xyz_abc.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}

					
iv> findByPhone
URL =>  http://localhost:8080/user/phone/1234567890
REQUEST BODY => No body needed.
OUTPUT => {
						"id": 10,
						"name": "xyz abc",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 0,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\xyz_abc.png",
						"picname": "xyz_abc.png",
						"pictemplate": "iVBORw0KGgoAAAANSUh..."
					}

v> findAll
URL =>  http://localhost:8080/user/users
REQUEST BODY => No body needed.
OUTPUT => [
						{"id":1,
						"name":"sri ijk",
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
						"name":"Rucha",
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
						"name":"Trupti ",
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
						"name":"san Ba",
						"gender":"Male",
						"dob":"1983-09-22T18:30:00.000+0000",
						"phone":"9815554378",
						"email":"san@gmail.com",
						"empid":4,
						"department":"Software Developer",
						"misc":"ZZZZZ",
						"picurl":"D:\\neuroImgDB\\san_Ba.png",
						"picname":"san_Ba.png",
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
						"name":"xyz abc",
						"gender":"male",
						"dob":"2000-01-31T00:00:00.000+0000",
						"phone":"1234567890",
						"email":"abc@abc.com",
						"empid":0,
						"department":"HR",
						"misc":"KKKKKKKKKK",
						"picurl":"D:\\neuroImgDB\\xyz_abc.png",
						"picname":"xyz_abc.png",
						"pictemplate":"iVBORw0KGgoAA..."}
						]

c. Update Rest Service - For UPDATING USER DATA
URL => http://localhost:8080/user/update/xyz%20abc
REQUEST BODY => { "empid": 6 }
OUTPUT => {
						"id": 10,
						"name": "xyz abc",
						"gender": "male",
						"dob": "2000-01-31T00:00:00.000+0000",
						"phone": "1234567890",
						"email": "abc@abc.com",
						"empid": 6,
						"department": "HR",
						"misc": "KKKKKKKKKK",
						"picurl": "D:\\neuroImgDB\\xyz_abc.png",
						"picname": "xyz_abc.png",
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


	

4. LoginDetails (for login)
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


	
5. First IN and Last OUT TIMINGS of Employee 
	a. By Date Rest Service - To get data of employee for the date
		URL =>  http://localhost:8080/attendance/fordate/2018-10-05
		REQUEST BODY => No body needed.
		OUTPUT => [["2018-10-05T17:32:13.000+0000","2018-10-05T18:00:31.000+0000","anonymous01.png"]]


b. By Month Rest Service - To get data of employee for the Month
i>. using abbreviation for month names ex Jan, FEB, mar,etc...
		URL =>  http://localhost:8080/attendance/formonth/OCT
		REQUEST BODY => No body needed.
		OUTPUT => [["2018-10-05T17:32:13.000+0000","2018-10-05T18:00:31.000+0000","anonymous01.png"]]

ii>. using  month names ex January, FEBRUARY, march,etc...
		URL =>  http://localhost:8080/attendance/formonth/OCTOBER
		REQUEST BODY => No body needed.
		OUTPUT => [["2018-10-05T17:32:13.000+0000","2018-10-05T18:00:31.000+0000","anonymous01.png"]]

iii>. using  date String ex “2018-10-09”
		URL =>  http://localhost:8080/attendance/formonth/2018-10-09
		REQUEST BODY => No body needed.
		OUTPUT => [["2018-10-05T17:32:13.000+0000","2018-10-05T18:00:31.000+0000","anonymous01.png"]]



c. Between Date Range Rest Service - To get data of employee Between the dates
		URL =>  http://localhost:8080/attendance/fromto?from=2018-09-27&to=2018-10-05
		REQUEST BODY => No body needed.
		OUTPUT => [["2018-10-05T17:32:13.000+0000","2018-10-05T18:00:31.000+0000","anonymous01.png"]]

	
Only one row as no data before 2018-10-05

6. UnIdentified Person
	a. Post Rest Service - For CREATING/ADDING UNIDENTIFIED PERSON DATA
	b. Get Rest Service - For GETTING UNIDENTIFIED PERSON DATA
	c. Update Rest Service -For  UPDATING UNIDENTIFIED PERSON DATA
	d. Delete Rest Service - For REMOVING UNIDENTIFIED PERSON DATA
	
7. Notification 
	a. Post Rest Service - For CREATING/ADDING NOTIFICATION DATA
	b. Get Rest Service - For GETTING NOTIFICATION DATA
	c. Update Rest Service -For  UPDATING NOTIFICATION DATA
	d. Delete Rest Service - For REMOVING NOTIFICATION DATA



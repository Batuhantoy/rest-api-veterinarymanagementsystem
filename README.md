# Veterinary Management System


## Application Structure

- Veterinary will add doctors,
- will record doctors' working days (available days),
- will be recorded as date and will record customers,
- will add customers' animals,
- will record the vaccinations applied to the animals with their dates,
- They will make appointments with doctor for animals,
- Date and time will be entered when creating an appointment,
- When making an appointment, the doctor's available days should be checked, and the date and time should be checked from the appointment records. If there is no conflict in the records, an appointment should be created.


![](/ss/ss1.PNG)

## Entities in the Project

Animal

- id:Long

- name:String

- species:String

- breed:String

- gender:String

- colour:String

- dateOfBirth:LocalDate

Customer

- id:Long

- name:String

- phone:String

- mail: String

- address:String

- city:String

Vaccine

- id: Long

- name: String

- code: String

- protectionStartDate: LocalDate

- protectionFinishDate: LocalDate

Doctor

- id:Long

- name:String

- phone:String

- mail: String

- address:String

- city:String

AvailableDate

- id:Long

- availableDate:LocalDate

Appointment

- id:Long

- appointmentDate:LocalDateTime


## End Points (URIs)

### Animal Endpoints
****
+ > GET : localhost:8080/v1/animals

+ > POST : localhost:8080/v1/animals

+ > PUT : localhost:8080/v1/animals

+ > DELETE : localhost:8080/v1/animals/{animalId}

+ > GET : localhost:8080/v1/animals/search?name={animalName}

+ > GET : localhost:8080/v1/animals/customer/{customerId}

+ > GET : localhost:8080/v1/animals/{animalId}

  
### Customer Endpoints
****
+ > GET : localhost:8080/v1/customers

+ > POST : localhost:8080/v1/customers

+ > PUT : localhost:8080/v1/customers

+ > DELETE : localhost:8080/v1/customers/{customerId}

+ > GET : localhost:8080/v1/customers/search?name={customerName}

+ > GET : localhost:8080/v1/customers/{customerId}


### Doctor Endpoints
****
+ > GET : localhost:8080/v1/doctors

+ > POST : localhost:8080/v1/doctors

+ > PUT : localhost:8080/v1/doctors

+ > DELETE : localhost:8080/v1/doctors/{doctorId}

+ > GET : localhost:8080/v1/doctors/{doctorId}


### Appointment Endpoints
****
+ > GET : localhost:8080/v1/appointments

+ > POST : localhost:8080/v1/appointments

+ > PUT : localhost:8080/v1/appointments

+ > DELETE : localhost:8080/v1/appointments/{appointmentId}

+ > GET : localhost:8080/v1/appointments/{appointmentId}

+ > GET : localhost:8080/v1/appointments/search/doctor?startDate={startDate}&endDate={endDate}&doctorName={doctorName}

+ > GET : localhost:8080/v1/appointments/search/animal?startDate={startDate}&endDate={endDate}&animalName={animalName}


### Vaccine Endpoints
****
+ > GET : localhost:8080/v1/vaccines

+ > POST : localhost:8080/v1/vaccines

+ > PUT : localhost:8080/v1/vaccines

+ > DELETE : localhost:8080/v1/vaccines/{vaccineId}

+ > GET : localhost:8080/v1/vaccines/{vaccineId}

+ > GET : localhost:8080/v1/vaccines/search/{animalId}

+ > GET : localhost:8080/v1/vaccines/search?startDate={startDate}&endDate={endDate}


### Doctors Available Date Endpoints
****
+ > GET : localhost:8080/v1/availabledates

+ > POST : localhost:8080/v1/availabledates

+ > PUT : localhost:8080/v1/availabledates

+ > DELETE : localhost:8080/v1/availabledates/{vaccineId}

+ > GET : localhost:8080/v1/availabledates/{vaccineId}


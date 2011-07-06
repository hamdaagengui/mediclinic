-- MySQL dump 10.13  Distrib 5.1.43, for Win32 (ia32)
--
-- Host: localhost    Database: mediapp
-- ------------------------------------------------------
-- Server version	5.1.43-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `code_decode`
--

LOCK TABLES `code_decode` WRITE;
/*!40000 ALTER TABLE `code_decode` DISABLE KEYS */;
INSERT INTO `code_decode` VALUES (1,'PERSON_TY','Doctor','doctor','Doctor'),(2,'PERSON_TY','Patient','patient','Patient'),(3,'APP_STRT_TIME','9:00 AM','Appointment can be taken only after this time','9:00 AM'),(4,'APP_STRT_TIME','5:00 PM','Appointment can be taken till this time','5:00 PM'),(5,'SPECIALTITY','Acupuncture','Uses procedures adapted from Chinese medicine to relieve pain or for therapeutic purposes.','Acupuncture'),(6,'SPECIALTITY','Addiction Medicine',' Works with patients who have substance abuse disorders. Specializes in prevention, diagnosis, treatment of withdrawal, medical or psychiatric complications, relapse, and the monitoring of recovery.','Addiction Medicine'),(7,'SPECIALTITY','Adolescent Medicine',' Focused on the care of people in the second decade of life. Problems in adolescence include sexual experiences resulting in pregnancies and sexually transmitted diseases, drug and alcohol use, violence-related behaviors, and reckless use of motor vehicles.','Adolescent Medicine'),(8,'SPECIALTITY','Aerospace Medicine ','Focused on the health of the crew, passengers, and support personnel of air and space vehicles.','Aerospace Medicine '),(9,'SPECIALTITY','Allergy ','Allergists diagnose and treat reactions due to irritating agents or allergens including foods, medicines, and pollens.','Allergy '),(10,'SPECIALTITY','Allergy/Immunology ','Concerned with the evaluation, diagnosis, and management of disorders involving the immune system, including asthma, eczema, allergic reactions, problems related to autoimmune disease, organ transplantation, and immune system malignancies.','Allergy/Immunology '),(11,'SPECIALTITY','Anesthesiology ','Provides relief from pain and maintains or restores a stable condition during surgical, obstetric, or diagnostic procedures. ','Anesthesiology '),(12,'SPECIALTITY','Audiologist ','Focused on identifying, diagnosing, and treating hearing disorders.','Audiologist '),(13,'SPECIALTITY','Bariatrician ','Focused on the care of obese patients.','Bariatrician '),(14,'SPECIALTITY','Cardiac Electrophysiology ','Involves complicated technical procedures to evaluate heart rhythms to determine appropriate treatment.','Cardiac Electrophysiology '),(15,'SPECIALTITY','Cardiology ','Focused on diseases of the heart, lungs, and blood vessels. Includes management of heart attacks and abnormal heart rhythms. Perform catheterization and consult with surgeons on heart surgery.','Cardiology '),(16,'SPECIALTITY','Chiropractic ','Therapeutic method of treatment based on interaction of the spine and nervous system.','Chiropractic '),(17,'SPECIALTITY','Clinical Laboratory Immunology ','Focused on conducting tests of specimens to determine a patient’s general health. Results are used by physicians to diagnose illnesses and determine proper treatment.','Clinical Laboratory Immunology '),(18,'SPECIALTITY','Clinical Pathology ','Concerned with diagnosing a disease based on laboratory analysis of body fluids.','Clinical Pathology '),(19,'SPECIALTITY','Colon/Rectal Surgery ','Diagnoses and treats various diseases of the intestinal tract, colon, rectum, and perianal area by medical and surgical means.','Colon/Rectal Surgery '),(20,'SPECIALTITY','Critical Care ','The Critical Care physician is based in the ICU or CCU and must have a broad knowledge of all aspects of management of the critically ill patient.','Critical Care '),(21,'SPECIALTITY','Cytopathology','Focused on the diagnosis of disease through the study of cells, including Pap tests. This specialist is a consultant to all medical specialists. ','Cytopathology'),(22,'SPECIALTITY','Dermatology ','Concerned with the prevention, diagnosis, and treatment of disorders of the skin and related tissues. Treats a number of sexually transmitted diseases and corrects cosmetic skin defects.','Dermatology '),(23,'SPECIALTITY','Dermatopathology ','Focused on the laboratory study of skin samples.','Dermatopathology '),(24,'SPECIALTITY','Diabetes Specialty ','Concerned with the diagnosis and treatment of metabolic disorders related to impairment or loss of pancreatic function.','Diabetes Specialty '),(25,'SPECIALTITY','Diagnostic Radiology ','Uses radiant energy in diagnosis and therapeutic procedures. Includes imaging through X-rays, ultrasound, etc.','Diagnostic Radiology '),(26,'SPECIALTITY','Emergency Medical Tech ','A healthcare provider trained to provide pre-hospital emergency medical services.','Emergency Medical Tech '),(27,'SPECIALTITY','Emergency Medicine ','Concerned with the immediate decisions and actions required to prevent further disability or death of a patient in an emergency room setting.','Emergency Medicine '),(28,'SPECIALTITY','Endocrinology ','Focused on the disorders of the glands, including organs and tissues that produce hormones and the treatment of hormonal disorders and diseases.','Endocrinology '),(29,'SPECIALTITY','Endovascular Surgical Neuroradiology ','ESNR specialists focus on less invasive, catheter-based techniques to treat patients who are unable to undergo conventional surgery or in situations where no conventional surgery options exist.','Endovascular Surgical Neuroradiology '),(30,'SPECIALTITY','Family Practice ','Concerned with the healthcare of an individual and family, including all ages. Integrates the biological, behavioral, and clinical sciences. ','Family Practice '),(31,'SPECIALTITY','Gastroenterology ','Focused on digestive organs including the stomach, bowels, liver, and gall bladder.','Gastroenterology '),(32,'SPECIALTITY','General Practice ','Concerned with the diagnosis and treatment of disease by both medical and surgical methods, regardless of organ system, body region, or patient age.','General Practice '),(33,'SPECIALTITY','General Surgery ','Management of surgical conditions that affect almost any area of the body.','General Surgery '),(34,'SPECIALTITY','Genetics ','The scientific study of heredity and hereditary diseases and disorders.','Genetics '),(35,'SPECIALTITY','Geriatrics ','Focused on the aging process and special skills required to treat illness in the elderly. Trained to recognize unusual presentations of illness and drug interaction.','Geriatrics '),(36,'SPECIALTITY','Gynecology','Concerned with the diagnosis and treatment of diseases of the female reproductive system.','Gynecology'),(37,'SPECIALTITY','Gynecology Oncology ','Focused on gynecologic cancer and its complications.','Gynecology Oncology '),(38,'SPECIALTITY','Hand Surgery ','Specializes in the medical and surgical treatment of the hand.','Hand Surgery '),(39,'SPECIALTITY','Head and Neck Surgery ','Surgical treatment of diseases and injuries of the head and neck.','Head and Neck Surgery '),(40,'SPECIALTITY','Hematology ','Focused on diseases of the blood, blood clotting mechanisms, bone marrow, spleen, and lymph glands.','Hematology '),(41,'SPECIALTITY','Hematology/Oncology ','Specifically trained to treat diseases of the blood and cancer.','Hematology/Oncology '),(42,'SPECIALTITY','Hepatology ','Concerned with treating liver, gallbladder, and pancreas disorders.','Hepatology '),(43,'SPECIALTITY','Holistic Medicine ','Focuses on the whole person and looks at physical, mental, spiritual, and emotional well-being prior to determining a treatment.','Holistic Medicine '),(44,'SPECIALTITY','Hospitalist ','Provides general medical care of hospital patients. Responsible for patient care and research. Coordinates with patient’s primary care/referring physician.','Hospitalist '),(45,'SPECIALTITY','Immunology ','Focused on the body’s ability to combat infectious or irritating substances that threaten it with disease.','Immunology '),(46,'SPECIALTITY','Infectious Disease ','Concerned with all types of infectious diseases in all organs.','Infectious Disease '),(47,'SPECIALTITY','Internal Medicine ','Focused on long-term comprehensive care. Manages common illnesses and complex medical problems.','Internal Medicine '),(48,'SPECIALTITY','Interventional Cardiology ','Focuses on catheter-based treatment of heart disease including angioplasty, valvuloplasty, and coronary thrombectomy.','Interventional Cardiology '),(49,'SPECIALTITY','Legal Medicine ','Focused on various aspects of medicine and the law, including the use of medicine to solve criminal cases, medical malpractice, and government regulation. ','Legal Medicine '),(50,'SPECIALTITY','Medical Oncology ','Focused on the diagnosis and treatment of all types of cancer and other benign and malignant tumors.','Medical Oncology '),(51,'SPECIALTITY','Medical Toxicology','Concerned with treating patients who have been exposed to poisons including medications, adverse drug reactions, environmental toxins, industrial chemicals, or bioterrorism agents.','Medical Toxicology'),(52,'SPECIALTITY','Neonatology ','Focused on medical care for ill newborn infants. Also serve as consultants to general pediatricians in routine care for newborns.','Neonatology '),(53,'SPECIALTITY','Nephrology ','Focused on scientific study of the kidney, its disorders, high blood pressure, fluid and mineral balance, and dialysis. Consults with surgeons regarding kidney transplantation.','Nephrology '),(54,'SPECIALTITY','Neurology ','Focused on the treatment of all diseases and impaired functions of the brain, spinal cord, and peripheral nerves.','Neurology '),(55,'SPECIALTITY','Neuroradiology ','Specifically trained in using digital angiography, MRI, CT, PET, ultrasound, and X-rays to evaluate the brain, head, neck, and spine.','Neuroradiology '),(56,'SPECIALTITY','Neurosurgery ','Provides operative and non-operative management of the central, peripheral, and autonomic nervous system. Includes the operative and non-operative management of pain.','Neurosurgery '),(57,'SPECIALTITY','Nuclear Cardiology ','Focuses on using small amounts of radioactive substances and non-invasive techniques to assess the health of a patient’s heart.','Nuclear Cardiology '),(58,'SPECIALTITY','Nuclear Medicine ','Focused on nuclear properties of radioactive and stable nuclides to evaluate conditions in clinical and laboratory settings.','Nuclear Medicine '),(59,'SPECIALTITY','Nutrition ','Concerned with food requirements and the effects of nutrients. ','Nutrition '),(60,'SPECIALTITY','Obstetrics/Gynecology ','Medical and surgical care of the female reproductive system and associated disorders.','Obstetrics/Gynecology '),(61,'SPECIALTITY','Occupational Medicine ','Focused on the health of workers, the ability to perform work, and physical and chemical environments of the workplace.','Occupational Medicine '),(62,'SPECIALTITY','Oncology ','Focuses on cancer and the diagnosis and treatment of tumors.','Oncology '),(63,'SPECIALTITY','Ophthalmology ','Comprehensive care of the eye and vision. Medical and surgical treatment of all eye, eyelid, and orbital problems.','Ophthalmology '),(64,'SPECIALTITY','Optometry ','Focuses on vision, visual systems, and the health of the eyes.','Optometry '),(65,'SPECIALTITY','Orthopedic Foot & Ankle ','Concerned with the medical and surgical treatment of diseases and injuries of the foot and ankle.','Orthopedic Foot & Ankle '),(66,'SPECIALTITY','Orthopedic Reconstructive Surgery ','Focused on surgical replacement of joints such as knee and hip.','Orthopedic Reconstructive Surgery '),(67,'SPECIALTITY','Orthopedic Spine Surgery ','Concerned with surgical treatment of diseases and injuries of the spine.','Orthopedic Spine Surgery '),(68,'SPECIALTITY','Orthopedic Surgery ','The preservation or restoration of form and function of the extremities, spine, and associated structures by medical, surgical, and physical means.','Orthopedic Surgery '),(69,'SPECIALTITY','Osteopathy ','Focuses on using conventional treatment methods as well as placing emphasis on body, mind, and spirit.','Osteopathy '),(70,'SPECIALTITY','Other Specialty ','A specialty other than those defined.','Other Specialty '),(71,'SPECIALTITY','Otorhinolaryngology ','The medical and surgical care of the ears, nose, throat, respiratory, and upper alimentary systems. Also called Otolaryngology. ','Otorhinolaryngology '),(72,'SPECIALTITY','Pain Management ','Specifically trained in the treatment and prevention of chronic pain or pain complicated by other medical conditions.','Pain Management '),(73,'SPECIALTITY','Pathology ','The scientific study of diseases and the structural and functional changes they cause.','Pathology '),(74,'SPECIALTITY','Pediatric Allergy ','Concerned with the diagnosis and treatment of allergies in children.','Pediatric Allergy '),(75,'SPECIALTITY','Pediatric Cardiology ','Concerned with the care of children with cardiovascular problems.','Pediatric Cardiology '),(76,'SPECIALTITY','Pediatric Critical Care','Concerned with the care of critically ill children in an ICU environment.','Pediatric Critical Care'),(77,'SPECIALTITY','Pediatric Emergency Medicine ','Concerned with the immediate decisions and actions required to prevent further disability or death of a child.','Pediatric Emergency Medicine '),(78,'SPECIALTITY','Pediatric Endocrinology ','Focused on care of children with diseases related to abnormalities in the endocrine glands, including diabetes mellitus, growth disorders, early or late puberty, birth defects, etc.','Pediatric Endocrinology '),(79,'SPECIALTITY','Pediatric Gastroenterology ','Focused on disorders of the digestive system of infants, children, and adolescents.','Pediatric Gastroenterology '),(80,'SPECIALTITY','Pediatric Hematology/Oncology ','Focused on the care of children with blood or cancerous diseases.','Pediatric Hematology/Oncology '),(81,'SPECIALTITY','Pediatric Internal Medicine ','Focused on the long-term relationship with a patient. Trained to provide care for newborns, children, adolescents, and adults. Physicians are typically certified in a Med/Peds program.','Pediatric Internal Medicine '),(82,'SPECIALTITY','Pediatric Neurology ','Care of the brain, spinal cord, and nervous system of children.','Pediatric Neurology '),(83,'SPECIALTITY','Pediatric Ophthalmology ','Concerned with providing comprehensive care of the eye and vision in children.','Pediatric Ophthalmology '),(84,'SPECIALTITY','Pediatric Psychiatry ','Focused on mental, addictive, and emotional disorders of children.','Pediatric Psychiatry '),(85,'SPECIALTITY','Pediatric Pulmonology','Care of diseases and disorders of the lungs of children.','Pediatric Pulmonology'),(86,'SPECIALTITY','Pediatric Radiology ','Focused on the pediatric application of imaging technologies.','Pediatric Radiology '),(87,'SPECIALTITY','Pediatric Surgery ','Focused on the management of surgical conditions in children.','Pediatric Surgery '),(88,'SPECIALTITY','Pediatrics ','Focused on the health of children from birth to young adulthood.','Pediatrics '),(89,'SPECIALTITY','Perinatal ','Focused on providing care either immediately before or after birth.','Perinatal '),(90,'SPECIALTITY','Physical Medicine/Rehab ','Concerned with maximal restoration of physical, psychological, social, vocational function, and alleviation of pain for patients with impairments or disabilities.','Physical Medicine/Rehab '),(91,'SPECIALTITY','Physician ','A physician with no known specialty.','Physician '),(92,'SPECIALTITY','Plastic Surgery ','Concerned with the repair and reconstruction of defects of the skin and its underlying musculoskeletal system, with emphasis on the face, head, limbs, breasts, and external genitalia.','Plastic Surgery '),(93,'SPECIALTITY','Podiatry ','Focused on the treatment of foot and ankle disorders.','Podiatry '),(94,'SPECIALTITY','Preventative Medicine ','Specifically trained in preventing disease, disability or premature death of individuals and populations.','Preventative Medicine '),(95,'SPECIALTITY','Psychiatry ','Focused on treatment of mental, addictive, and emotional disorders.','Psychiatry '),(96,'SPECIALTITY','Psychology ','Focused on the treatment of mental functions and behaviors.','Psychology '),(97,'SPECIALTITY','Pulmonary Critical Care ','Concerned with caring for patients with life-threatening pulmonary illnesses such as COPD, asthma, emphysema, lung cancer, and pneumonia.','Pulmonary Critical Care '),(98,'SPECIALTITY','Pulmonology ','Concerned with diseases of the lungs and airways. ','Pulmonology '),(99,'SPECIALTITY','Radiation Oncology ','Deals with the therapeutic applications of radiant energy and the study and management of cancers and other diseases.','Radiation Oncology '),(100,'SPECIALTITY','Radiology ','Deals with diagnostic and therapeutic applications of radiant energy.','Radiology '),(101,'SPECIALTITY','Reproductive Endocrinology ','Focused on problems related to endocrinology and infertility.','Reproductive Endocrinology '),(102,'SPECIALTITY','Rheumatology ','Concerned with diseases of the joints, muscles, bones, and tendons, including arthritis, back pain, and muscle strains. ','Rheumatology '),(103,'SPECIALTITY','Sleep Medicine ','Focused on the diagnosis and treatment of sleep disorders.','Sleep Medicine '),(104,'SPECIALTITY','Sports Medicine ','Specifically trained to treat sports injuries of both athletes and active individuals.','Sports Medicine '),(105,'SPECIALTITY','Surgical Oncology','Focused on the surgical management of malignant tumors.','Surgical Oncology'),(106,'SPECIALTITY','Thoracic Surgery ','Operative care of patients with conditions within the chest, including coronary artery disease, lung cancer, esophageal cancer, heart valve, and major vessel abnormalities.','Thoracic Surgery '),(107,'SPECIALTITY','Transplant Surgery','Focused on surgically transplanting organs, including the kidney, liver, lung, or pancreas.','Transplant Surgery'),(108,'SPECIALTITY','Trauma Surgery ','Deals with the treatment of wounds and injuries through surgical methods.','Trauma Surgery '),(109,'SPECIALTITY','Urgent Care ','Specifically trained in providing treatment of non-emergency illnesses and injuries such as sore throats, ear infections, minor cuts and bruises.','Urgent Care '),(110,'SPECIALTITY','Urology ','Concerned with medical and surgical treatment of disorders of the urinary and male reproductive systems.','Urology '),(111,'SPECIALTITY','Vascular & Interventional Radiology ','Focused on using images and minimally invasive procedures for diagnostic or treatment purposes.','Vascular & Interventional Radiology '),(112,'SPECIALTITY','Vascular Surgery ','Concerned with the surgical treatment of disorders of the blood vessels.','Vascular Surgery '),(113,'SPECIALTITY','Women’s Health ','Specifically trained to provide diagnosis and treatment related to women’s health issues. ','Women’s Health '),(114,'APPOINTMENT_DURATION','00:30:00','30 Minutes','00:30:00'),(115,'APPOINTMENT_DURATION','01:00:00','1 Hours','01:00:00'),(116,'REPORTTYPES','Medical Report','Any kind of medical report','Medical Report'),(117,'REPORTTYPES','X-Ray Report','Soft Copy of X-Ray','X-Ray Report'),(118,'PERSONTYPE','Accountants','Accountants','Accountants'),(119,'PERSONTYPE','Actuaries','Actuaries','Actuaries'),(120,'PERSONTYPE','Advocate','Advocates','Advocates'),(121,'PERSONTYPE','Architect','Architects','Architect'),(122,'PERSONTYPE','Dentist','Dentists','Dentist'),(123,'PERSONTYPE','Engineer','Engineers','Engineer'),(124,'PERSONTYPE','Lawyer','Lawyers','Lawyer'),(125,'PERSONTYPE','Librarian','Librarians','Librarian'),(126,'PERSONTYPE','Nurse','Nurses','Nurse'),(127,'PERSONTYPE','Pharmacist','Pharmacists','Pharmacist'),(128,'PERSONTYPE','Doctor','Doctor','Doctor'),(129,'PERSONTYPE','Professor','Professors','Professor'),(130,'PERSONTYPE','Teacher','Teachers','Teacher'),(131,'PERSONTYPE','Statistician','Statisticians','Statistician'),(132,'REMINDER_END_TIME','0','Reminder end time',NULL),(133,'REMINDER_START_TIME','-7200','Reminder start time',NULL),(134,'SMS','ON','SMS mode',NULL),(135,'Email','ON','Emailing mode',NULL),(136,'SMSREAD','ON','SMS read processing',NULL),(137,'SMSSERVER','C:/Documents and Settings/Administrator/Desktop/padmaraj/demo/mediclinic/workspace/with search/work1/mediApp/WEB-INF/','smsserver.configdir','smsserver.configdir'),(138,'SMSPROCESSTHRESHOLD','180','This is the time before next thread will reprocess the SMS',NULL),(139,'WORKSTARTTIME','01:00:00',NULL,NULL),(140,'WORKENDTIME','23:59:59',NULL,NULL),(141,'PACKAGES','Basic','This is Basic package',NULL),(142,'PACKAGES','Patient','This for Patients','Medical Assistance'),(143,'PACKAGES','Doctor','This is for Doctors','Doctors');
/*!40000 ALTER TABLE `code_decode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `code_category`
--

LOCK TABLES `code_category` WRITE;
/*!40000 ALTER TABLE `code_category` DISABLE KEYS */;
INSERT INTO `code_category` VALUES (1,'PERSON_TY','Y'),(2,'APP_STRT_TIME','Y'),(3,'SPECIALTITY','Y'),(4,'APPOINTMENT_DURATION','Y'),(5,'REPORTTYPES','Y'),(6,'PERSONTYPE','Y'),(7,'REMINDER_END_TIME','Y'),(8,'REMINDER_START_TIME','Y'),(9,'SMS','Y'),(10,'Email','Y'),(11,'SMSREAD','Y'),(12,'SMSSERVER','Y'),(13,'SMSPROCESSTHRESHOLD','Y'),(16,'WORKSTARTTIME','Y'),(17,'WORKENDTIME','Y'),(18,'PACKAGES','Y');
/*!40000 ALTER TABLE `code_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-07-06 23:37:13

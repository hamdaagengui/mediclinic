

CREATE TABLE `mediapp`.`sequence_data` ( 
    `sequence_name` varchar(100) NOT NULL,     
`sequence_increment` int(11) unsigned NOT NULL DEFAULT 1,     
`sequence_min_value` int(11) unsigned NOT NULL DEFAULT 1,     
`sequence_max_value` bigint(20) unsigned NOT NULL DEFAULT 18446744073709551615,   
`sequence_cur_value` bigint(20) unsigned DEFAULT 1,    
`sequence_cycle` boolean NOT NULL DEFAULT FALSE,     
PRIMARY KEY (`sequence_name`) )
 
 
 INSERT INTO mediapp.sequence_data 
(sequence_name, sequence_increment, sequence_max_value) 
VALUE 
 ('sq_sequence_2', 10, 100) ;
 
 
 CREATE FUNCTION `nextval` (`seq_name` varchar(100)) 
 RETURNS bigint(20) NOT DETERMINISTIC 
 BEGIN    
 DECLARE cur_val bigint(20);   
 SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp.sequence_data     
 WHERE        
 sequence_name = seq_name;    
 IF cur_val IS NOT NULL THEN        
 UPDATE            
 mediapp.sequence_data         
 SET            
 sequence_cur_value = IF (                 
 (sequence_cur_value + sequence_increment) > sequence_max_value,                 
 IF (                     
 sequence_cycle = TRUE,                     
 sequence_min_value,                     
 NULL                
 ),                 
 sequence_cur_value + sequence_increment             
 )         
 WHERE            
 sequence_name = seq_name         
 ;     
 END IF; 
 RETURN cur_val; 
 END;
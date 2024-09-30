package FitnessSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FitnessSpring.entity.Contact;

import FitnessSpring.repo.ContactRepository;

@Service
public class ContactService {

	
	    @Autowired
    private ContactRepository contactRepository;
	    
	    public Contact registerContact(String name, String email,String phone,String message) {
	        Contact contact = new Contact();
	        contact.setName(name);
	        contact.setEmail(email); 
	        contact.setPhone(phone); 
	        contact.setMessage(message);// In real life, hash the password
	        return contactRepository.save(contact);
	    } 
	     
}

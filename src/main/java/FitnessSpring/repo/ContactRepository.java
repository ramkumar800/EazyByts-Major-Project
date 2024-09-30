package FitnessSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FitnessSpring.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
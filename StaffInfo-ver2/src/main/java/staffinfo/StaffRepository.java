package staffinfo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StaffRepository extends JpaRepository<Staff, Integer> {

    Optional<Staff> findByName(String name);
    
    List<Staff> findByNameContaining(String name);
   
    
}

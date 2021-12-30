package staffinfo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceAPI {
    
    
    private StaffRepository staffR;
  
    
    ServiceAPI(StaffRepository staffR){
        this.staffR = staffR;
    }

   
   @GetMapping("/searchAll")
   public List<Staff> sayHello(){
       
        return staffR.findAll();
       }
   
   
    @GetMapping(path = "/searchByName")
    public Staff serchByName(String name){
        Optional<Staff> staff = staffR.findByName(name);
        return staff.get();
    }
    
    @GetMapping("/searchById")
    public Staff serchID(int id){
        Optional<Staff> staff = staffR.findById(id);                  
        return staff.get();
    }
   

  
    
}
    


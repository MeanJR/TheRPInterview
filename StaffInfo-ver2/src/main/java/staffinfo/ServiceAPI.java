package staffinfo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceAPI {

    private StaffRepository staffR;

    ServiceAPI(StaffRepository staffR) {
        this.staffR = staffR;
    }

    @GetMapping("/searchAll")
    public List<Staff> sayHello() {

        return staffR.findAll();
    }

    @GetMapping(path = "/searchByName")
    public Staff serchByName(String name) {
        Optional<Staff> staff = staffR.findByName(name);
        return staff.get();
    }

    @GetMapping(path = "/searchByName2")
    public List<Staff> serchByNameContain(String name) {
        String lowName = convertLower(name);
        List<Staff> list = staffR.findByNameContaining(lowName);
        if (!list.isEmpty()) {
            return list;
        } else {

            String newName = convertUpperFirst(name);
            list = staffR.findByNameContaining(newName);
            return list;
        }
    }

    @GetMapping("/searchById")
    public Staff serchID(int id) {
        Optional<Staff> staff = staffR.findById(id);
        return staff.get();
    }

    public String convertUpperFirst(String input) {
        String name = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        return name;
    }

    public String convertLower(String input) {
        String name = input.substring(0).toLowerCase();
        return name;
    }

}

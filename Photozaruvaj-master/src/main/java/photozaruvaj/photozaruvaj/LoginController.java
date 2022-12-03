package photozaruvaj.photozaruvaj;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller

public class LoginController {

    @GetMapping(value = "/index")
    public String Something ()
    {
        return "index";
    }
}

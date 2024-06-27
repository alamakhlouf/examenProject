package tn.esprit.spring.alaeddinemakhlouf.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.alaeddinemakhlouf.Service.ServiceInterface;

@RestController
@RequestMapping("app")
@AllArgsConstructor
public class Controller
{
    ServiceInterface serviceInterface ;
}

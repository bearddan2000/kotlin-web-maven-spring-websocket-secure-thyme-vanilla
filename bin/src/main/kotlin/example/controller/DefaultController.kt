package example.controller
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler

@Controller
class DefaultController {

    @GetMapping("/")
    fun home() :String {
        return "/home"
    }

    @GetMapping("/login")
    fun login() :String {
        return "/login"
    }

    @GetMapping("/login?logout")
    fun logout() :String {
      SecurityContextHolder.getContext().setAuthentication(null)
      return "redirect:/"
    }
}

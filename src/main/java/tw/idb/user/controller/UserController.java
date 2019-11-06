package tw.idb.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idb.user.exception.SystemErrorException;
import tw.idb.user.exception.UnAuthorizedException;
import tw.idb.user.response.Response;
import tw.idb.user.service.TokenService;
import tw.idb.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("tokenService")
    private TokenService tokenService;

    @RequestMapping(value = "/getUser/{userid}" , method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<Response> getUser(
            @RequestHeader(value = "token", required = false) String token,
            @NotBlank @PathVariable(value = "userid", required = false) String userid) {
        Response response;

        if(!tokenService.checkToken(token)) throw new UnAuthorizedException();

        try{
            response = userService.getUser(userid);
        }catch (Exception e ){
            throw new SystemErrorException();
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

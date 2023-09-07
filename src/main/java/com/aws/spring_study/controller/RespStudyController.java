package com.aws.spring_study.controller;

import com.aws.spring_study.dto.JsonTestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController // 컨트롤러의 재역할을 함, 데이터를 응답
public class RespStudyController {

    @GetMapping("/resp/str")
    public  String strTest() {
        return "문자열"; // Stirng으로 리턴
    }

    @GetMapping("/resp/obj")
    public Object objectTest() {
        Map<String, Object> responseMap = new HashMap<>();
        return responseMap; // JSON으로 응답
    }

    @GetMapping("/resp/obj2")
    public Object objectTest2() {
        JsonTestDto jsonTestDto = new JsonTestDto(); // 객체 key,value
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
        return jsonTestDto; // JSON으로 응답
    }

    @GetMapping("/resp/status")
    public Object statusTest(HttpServletResponse response) { // servlet 처럼 가지고 올 수 있음
        response.setStatus(400);
        return null;
    }

    @GetMapping("/resp/resp-entity")
    public ResponseEntity<JsonTestDto> responseEntityTest() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
        return new ResponseEntity<JsonTestDto>(jsonTestDto, HttpStatus.UNAUTHORIZED); // UNAUTHORIZED 401 에러
        // <> 응답되어진 데이터의 타입이 위에서는 JsonTestDto ,
        // ResponseEntity는 공통으로 사용되는 응답객체, 모든상황에서 사용, 여러형태 일수있기 때문에 제너릭 타입을 잡아준다.
        // (body, status) 순서대로 입력
    }

    @GetMapping("/resp/map-resp-entity")
    public ResponseEntity<Map<String, Object>> mapResponseEntity() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "데이터입니다.");
        return new ResponseEntity<>(map, HttpStatus.OK); 
    }

    // 최종적인 응답(Response)의 형태
    @GetMapping("/resp")
    public ResponseEntity<JsonTestDto> jsonResponse() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
//        return ResponseEntity.ok().body(jsonTestDto); // return 부분이 응답
//        return ResponseEntity.badRequest().body(jsonTestDto);
//        return ResponseEntity.status(405).body(jsonTestDto);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonTestDto);
        // 응답 방식은 위의 return 4가지 처럼 여러가지가 있다.
    }
}

// 요청은 메소드가 중요
// 응답은 status코드가 중요

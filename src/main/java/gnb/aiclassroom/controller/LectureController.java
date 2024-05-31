package gnb.aiclassroom.controller;

import gnb.aiclassroom.dto.LectureDTO;
import gnb.aiclassroom.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lecture")
public class LectureController {

    private LectureService lectureService;

    // 강의 등록
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<String> createLecture(@RequestBody LectureDTO lectureDTO) {
        lectureService.createLecture(lectureDTO);
        return new ResponseEntity<>("Lecture created successfully", HttpStatus.CREATED);
    }

    // 강의 수정
    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLecture(@PathVariable Long id, @RequestBody LectureDTO lectureDTO) {
        lectureService.updateLecture(id, lectureDTO);
        return new ResponseEntity<>("Lecture updated successfully", HttpStatus.OK);
    }

    // 강의 삭제
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return new ResponseEntity<>("Lecture deleted successfully", HttpStatus.OK);
    }

    // 강의 검색
    @CrossOrigin
    @GetMapping("/search")
    public ResponseEntity<List<LectureDTO>> searchLectures(@RequestParam String keyword) {
        List<LectureDTO> lectures = lectureService.searchLectures(keyword);
        return new ResponseEntity<>(lectures, HttpStatus.OK);
    }

}

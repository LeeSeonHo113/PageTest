package site.metacoding.pagetest.openapi.contents.field;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DownloadContentsField {

    private final ContentsFieldRepository contentsfieldRepository;

    @GetMapping("/")
    public String main() {
        return "/download";
    }

    @GetMapping("/download")
    public String download(Model model) {
        // 1. URI로 다운로드
        RestTemplate rt = new RestTemplate();
        ContentsField[] contentsfield = rt.getForObject(
                "http://www.pettravel.kr/api/detailSeqPart.do?partCode=PC02&contentNum=1",
                ContentsField[].class);
        List<ContentsField> ContentsField = Arrays.asList(contentsfield);
        // 2. DB에 saveAll() + model에 담기
        contentsfieldRepository.saveAll(ContentsField);
        model.addAttribute("contentsfield", contentsfield);
        // 3. 리턴
        return "/list";
    }
}
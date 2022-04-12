package site.metacoding.pagetest.openapi.contents.field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentsField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private Integer id;
    private String addr;
    private Integer mgtStaDd;
    private String pcrPsblYn;
    private String ratPsblYn;
    private Integer recuClCd;
    private String sgguCdNm;
    private String sidoCdNm;
    private String yadmNm;
    private String ykihoEnc;
    private String xposWgs84;
    private String yposWgs84;
    private String xpos;
    private String ypos;
}
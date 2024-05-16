package data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@ToString
@Data //Setter+Getter+ToString
public class ShopDto {
    private String sang;
    private String photo;
    private int price;
    private int su;
}

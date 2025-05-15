package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
//        for (String messageCode : messageCodes) {
//            System.out.println("messageCode = " + messageCode); // required.item, required의 순으로 출력됨.
//        }
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodedResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
//        for (String messageCode : messageCodes) {
//            System.out.println("messageCode = " + messageCode); // 객체명+필드명, 필드명, 타입, 값 순으로 출력됨.
//        }
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}

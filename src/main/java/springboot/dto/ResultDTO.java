package springboot.dto;

import lombok.*;

/**
 * 统一返回结果DTO
 * @author yinyg
 * @date 2023/5/4
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO<T> {

    /** 是否成功 */
    private boolean success = true;

    /** 编码 */
    private int code = 200;

    /** 描述信息 */
    private String message;

    /** 数据 */
    private T data;

    public ResultDTO<T> data(T data) {
        this.data = data;
        return this;
    }

}

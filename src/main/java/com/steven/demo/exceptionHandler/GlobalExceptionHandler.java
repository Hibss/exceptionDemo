package com.steven.demo.exceptionHandler;

import com.steven.demo.common.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 * @Author steven.sheng
 * @Date 2018/12/25/025.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public CommonResponse process(Exception e, HttpServletRequest request){
        if (request != null && request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
//            logger.error("BAD_REQUEST_BODY:{}", StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        }

        if(e instanceof MethodArgumentNotValidException){
            logger.error("参数不正确 {}",e);
            return CommonResponse.fail(-1).setMsg("参数不正确");
        }
        if(e instanceof SQLException){
            SQLException sqlException = (SQLException) e;
            logger.error("数据库异常 {}",sqlException);
            return CommonResponse.fail(-1).setMsg("数据库异常,操作失败");
        }
        logger.error("系统异常 {}",e);
        return CommonResponse.fail(-1).setMsg("系统异常:"+e.getMessage());
    }
}

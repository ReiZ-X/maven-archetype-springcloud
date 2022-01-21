package ${{groupId}}.${{projectPkg}};

import ${{groupId}}.${{projectPkg}}.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author junke
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R<Void> requestMessageNotReadable(HttpMessageNotReadableException ex) {
        log.error(requestUri(), ex);
        return R.fail( "参数body错误");
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public R<Void> requestMethodNotSupport(HttpMediaTypeNotSupportedException ex) {
        log.error(requestUri(), ex);
        return R.fail("HttpMediaType不支持");
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R<Void> requestMethodNotSupport(HttpRequestMethodNotSupportedException ex) {
        log.error(requestUri(), ex);
        return R.fail("method不支持");
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public R<Void> bindException(Exception ex) {
        log.error(requestUri(), ex);
        BindingResult bindResult;
        if (ex instanceof BindException) {
            bindResult = ((BindException) ex).getBindingResult();
        } else {
            bindResult = ((MethodArgumentNotValidException) ex).getBindingResult();
        }
        List<FieldError> fieldErrors = bindResult.getFieldErrors();
        String msg = generateMsg(fieldErrors);
        return R.fail( msg);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ServletRequestBindingException.class)
    public R<Void> handleServletRequestBindingException(ServletRequestBindingException ex) {
        log.error(requestUri(), ex);
        return R.fail(ex.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public R<Void> requestMissingServletRequest(MissingServletRequestParameterException ex) {
        log.error(requestUri(), ex);
        return R.fail( "lack necessary param:" + ex.getParameterName());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public R<Void> handleError(Throwable ex) {
        log.error(requestUri(), ex);
        return R.fail();
    }

    private String generateMsg(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder("参数缺失：");
        sb.append("{");
        for (FieldError error : fieldErrors) {
            sb.append(error.getField()).append(":").append(error.getDefaultMessage()).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }

    private String requestUri() {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (null == requestAttributes) {
                return "unknown request uri";
            }
            HttpServletRequest request = requestAttributes.getRequest();
            return request.getRequestURI();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}

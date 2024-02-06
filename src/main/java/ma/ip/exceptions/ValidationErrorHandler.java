package ma.ip.exceptions;

import ma.ip.enums.ErrorLevel;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorHandler implements ErrorHandler {

    private List<ValidationError> validationErrors = new ArrayList<>();

    public List<ValidationError> getValidationErrors() {
        return this.validationErrors;
    }


    public void warning(SAXParseException exception) throws SAXException {

        handleMessage(ErrorLevel.WARNING, exception);
    }


    public void error(SAXParseException exception) throws SAXException {

        handleMessage(ErrorLevel.ERROR, exception);
    }


    public void fatalError(SAXParseException exception) throws SAXException {

        handleMessage(ErrorLevel.FATAL, exception);
    }

    private void handleMessage(ErrorLevel level, SAXParseException exception) throws SAXException {

        int lineNumber = exception.getLineNumber();

        int columnNumber = exception.getColumnNumber();

        String message = exception.getMessage();

        this.validationErrors.add(new ValidationError(level, lineNumber, columnNumber, message));
    }


    public boolean hasNoErrors() {

        return !(countErrors() + countFatals() > 0);
    }

    public int countAllErrors() {

        return this.validationErrors.size();
    }

    public int countErrors() {

        return errorCounter(ErrorLevel.ERROR);
    }

    public int countWarnings() {

        return errorCounter(ErrorLevel.WARNING);
    }

    public int countFatals() {

        return errorCounter(ErrorLevel.FATAL);
    }

    private int errorCounter(ErrorLevel errorLevel) {

        return (int) this.validationErrors.stream().filter(error -> error.getErrorLevel().equals(errorLevel)).count();
    }
}

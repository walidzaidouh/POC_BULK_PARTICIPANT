package ma.ip.exceptions;


import ma.ip.enums.ErrorLevel;

public class ValidationError {
    private ErrorLevel errorLevel;
    private int lineNumber;
    private int columnNumber;
    private String message;

    public void setErrorLevel(ErrorLevel errorLevel) {
        this.errorLevel = errorLevel;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidationError(ErrorLevel errorLevel, int lineNumber, int columnNumber, String message) {
        this.errorLevel = errorLevel;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.message = message;
    }

    public ErrorLevel getErrorLevel() {
        return this.errorLevel;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "[" + this.errorLevel + "] Numero de ligne: " + this.lineNumber + " Numero de colonne: " + this.columnNumber + " message: " + this.message + "\n";
    }
}

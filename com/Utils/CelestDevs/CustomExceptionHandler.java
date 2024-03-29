package com.Utils.CelestDevs;

public class CustomExceptionHandler {

    public static String handleException(Throwable e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        if (stackTrace.length > 0) {
            StackTraceElement element = stackTrace[0];
            String methodName = element.getMethodName();
            String className = element.getClassName();

            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Erro no método: ").append(methodName).append("\n");
            errorMessage.append("Classe: ").append(className).append("\n");
            errorMessage.append("Erro: ").append(e.getMessage()).append("\n");

            // Se desejar, você pode adicionar mais informações sobre a exceção
            // errorMessage.append("StackTrace: ").append(Arrays.toString(stackTrace)).append("\n");

            return errorMessage.toString();
        }

        // Caso a pilha de chamadas não tenha informações suficientes
        return "Erro desconhecido: " + e.getMessage();
    }
}

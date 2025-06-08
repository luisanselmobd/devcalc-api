package com.devcalc;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Main {

    private static double[] obterParametrosOuErro(Context contexto) {
        String parametroA = contexto.queryParam("a");
        String parametroB = contexto.queryParam("b");

        if (parametroA == null && parametroB == null) {
            contexto.status(400).result("Parâmetros 'a' e 'b' são obrigatórios.");
            return null;
        }
        if (parametroA == null) {
            contexto.status(400).result("Parâmetro 'a' é obrigatório.");
            return null;
        }
        if (parametroB == null) {
            contexto.status(400).result("Parâmetro 'b' é obrigatório.");
            return null;
        }

        try {
            double a = Double.parseDouble(parametroA);
            double b = Double.parseDouble(parametroB);
            return new double[] { a, b };
        } catch (NumberFormatException e) {
            contexto.status(400).result("Parâmetros 'a' e 'b' devem ser números válidos.");
            return null;
        }
    }

    private static Double obterParametroX(Context contexto) {
        String parametroX = contexto.queryParam("x");

        if (parametroX == null) {
            contexto.status(400).result("Parâmetro 'x' é obrigatório.");
            return null;
        }

        try {
            return Double.parseDouble(parametroX);
        } catch (NumberFormatException e) {
            contexto.status(400).result("Parâmetro 'x' deve ser um número válido.");
            return null;
        }
    }


    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        CalculatorService calculatorService = new CalculatorService();

        app.get("/", contexto -> {
            contexto.result("Funcionando");
        });

        app.get("/add", contexto -> {
            double[] parametros = obterParametrosOuErro(contexto);
            if (parametros == null) return;
            contexto.result(String.valueOf(calculatorService.add(parametros[0], parametros[1])));
        });

        app.get("/subtract", contexto -> {
            double[] parametros = obterParametrosOuErro(contexto);
            if (parametros == null) return;
            contexto.result(String.valueOf(calculatorService.subtract(parametros[0], parametros[1])));
        });

        app.get("/multiply", contexto -> {
            double[] parametros = obterParametrosOuErro(contexto);
            if (parametros == null) return;
            contexto.result(String.valueOf(calculatorService.multiply(parametros[0], parametros[1])));
        });

        app.get("/divide", contexto -> {
            double[] parametros = obterParametrosOuErro(contexto);
            if (parametros == null) return;
            try {
                double resultado = calculatorService.divide(parametros[0], parametros[1]);
                contexto.result(String.valueOf(resultado));
            } catch (IllegalArgumentException e) {
                contexto.status(400).result(e.getMessage());
            }
        });

        app.get("/sqrt", contexto -> {
            Double parametro = obterParametroX(contexto);
            if (parametro == null) return;
            contexto.result(String.valueOf(calculatorService.sqrt(parametro)));
        });

    }
}

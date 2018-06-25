package br.com.fatec.historico.model;

public abstract class BaseHTML {
    private final String HTMLTOPO = "<!DOCTYPE html>\n" +
                                    " <html>\n" +
                                    " <head>\n" +
                                    "<link rel='stylesheet' href='style.css'>" +
                                    "<meta charset='utf-8'>" +
                                    " 	<title>Histórico</title>\n" +
                                    " </head>\n" +
                                    " <body>\n" +
                                    "<div class='container'>" +
                                    "<hr>\n" +
                                    "<h1 id='titulo'>Histórico</h1>\n" +
                                    " <hr>\n" +
                                    "<h1 class='autores'>Cliente:</h1> <span> %cliente% </span> <br>\n" +
                                    " <h1 class='autores'>Animal:</h1> <span> %animal% </span>\n" +
                                    " <hr>\n" +
                                    "<h1>Consultas:</h1>";
    
    private final String HTMLCHAO = "</div> " +
                                    "</body>\n" +
                                    " </html>";

    protected String getHTMLTOPO() {
        return HTMLTOPO;
    }

    protected String getHTMLCHAO() {
        return HTMLCHAO;
    }
    
}

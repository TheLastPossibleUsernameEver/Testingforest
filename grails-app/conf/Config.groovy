grails {
    mail {
        host = "smtp.yandex.ru"
        port = 465
        username = "testingforest@yandex.ru"
        password = "kMEMW@9GgN4dOUV"
        props = [
                "mail.smtp.auth":"true",
                "mail.smtp.socketFactory.port":"465",
                "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
                "mail.smtp.socketFactory.fallback":"false"]
    }
}

package com.mh.apifacturacion.dto;

public class AuthResponse {
    private String status;
    private Body body;

    public static class Body {
        private String user;
        private String token;
        private String rol;
        private String tokenType = "Bearer";

        public String getUser() { return user; }
        public void setUser(String user) { this.user = user; }
        public String getToken() { return token; }
        public void setToken(String token) { this.token = token; }
        public String getRol() { return rol; }
        public void setRol(String rol) { this.rol = rol; }
        public String getTokenType() { return tokenType; }
        public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Body getBody() { return body; }
    public void setBody(Body body) { this.body = body; }
}

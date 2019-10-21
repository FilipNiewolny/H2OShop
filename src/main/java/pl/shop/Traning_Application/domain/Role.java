package pl.shop.Traning_Application.domain;

public enum Role {
    ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

    private final String role;

    public String getRole() {
        return role;
    }

    Role(String role) {
        this.role = role;
    }
}

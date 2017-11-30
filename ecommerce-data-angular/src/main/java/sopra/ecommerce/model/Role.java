package sopra.ecommerce.model;

public enum Role {
	
ADMIN_CAT("role.adminCat"), ADMIN_PROD("role.adminProd"), CLIENT("role.client");
	
	private final String label;
	
	private Role(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}

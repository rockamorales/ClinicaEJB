package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the URLSMENU database table.
 * 
 */

@NamedQueries({
	@NamedQuery(name="urlsmenu.findByCodigomenu",query="Select u from CatUrlMenu u where u.codMenu = :codigomenu")
})
@Entity
@Table(name="cat_url_menu")
public class CatUrlMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long codUrlMenu;
    private Long codMenu;
    private String urlMenu;
    private CatMenu catMenu;

    public CatUrlMenu() {
    }

    @ManyToOne
    @JoinColumn(name="cod_menu",referencedColumnName="cod_menu",updatable=false, insertable=false)
    public CatMenu getCatMenu() {
            return catMenu;
    }

    public void setCatMenu(CatMenu menu) {
            this.catMenu = menu;
    }

    @Id
    @Column(name="cod_menu")
    public Long getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(Long codMenu) {
        this.codMenu = codMenu;
    }

    @Column(name="cod_url_menu")
    public Long getCodUrlMenu() {
        return codUrlMenu;
    }

    public void setCodUrlMenu(Long codUrlMenu) {
        this.codUrlMenu = codUrlMenu;
    }

    @Column(name="url_menu")
    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CatUrlMenu other = (CatUrlMenu) obj;
        if (this.codUrlMenu != other.codUrlMenu && (this.codUrlMenu == null || !this.codUrlMenu.equals(other.codUrlMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.codUrlMenu != null ? this.codUrlMenu.hashCode() : 0);
        return hash;
    }    
}
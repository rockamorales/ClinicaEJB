package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the menu database table.
 * 
 */
@NamedQueries({
	@NamedQuery(name="menu.findNonPublicMenu",query="Select m from CatMenu m where m.codPadMenu is null order by nomOpcMenu"),
	@NamedQuery(name="menu.findByParent",query="Select m from CatMenu m where m.codPadMenu = :codPadMenu order by nomOpcMenu"),
	@NamedQuery(name="menu.findAllNonPublicMenu",query="Select new sv.com.cormaria.servicios.entidades.security.CatMenu(m.codMenu, m.codPadMenu, m.icoMenu, m.nomOpcMenu, (Select count(*) from CatRolesMenu rm where rm.id.codRol = :rolesid  and rm.id.codMenu = m.codMenu)) from CatMenu m order by nomOpcMenu"),
	@NamedQuery(name="menu.findAllMenu",query="Select m from CatMenu m order by nomOpcMenu"),
	@NamedQuery(name="menu.findPublicMenu",query="Select m from CatMenu m where m.codPadMenu is null and 1 = :test order by nomOpcMenu")
})

@Entity
@Table(name="cat_menu")
public class CatMenu implements Serializable {
	private static final long serialVersionUID = 1L;
        private Long codMenu;
        private Long codPadMenu;
        private String icoMenu;
        private String nomOpcMenu;
        private String urlIniMenu;
	private CatMenu menu;
        private Boolean inrole;
	private HashSet<CatMenu> options = new HashSet<CatMenu>();
	private List<CatUrlMenu> urlsMenuList;

	public CatMenu(Long codMenu, Long codPadMenu, String icoMenu, String nomOpcMenu, Long countrole){
		this.codMenu = codMenu;
		this.codPadMenu = codPadMenu;
		this.icoMenu = icoMenu;
		this.nomOpcMenu = nomOpcMenu;
		this.inrole = countrole>0;
	}
	
	public CatMenu(){
	}

	@Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="cod_menu")
        public Long getCodMenu() {
            return codMenu;
        }

        public void setCodMenu(Long codMenu) {
            this.codMenu = codMenu;
        }

        @Column(name="cod_pad_menu")
        public Long getCodPadMenu() {
            return codPadMenu;
        }

        public void setCodPadMenu(Long codPadMenu) {
            this.codPadMenu = codPadMenu;
        }

        @Column(name="ico_menu")
        public String getIcoMenu() {
            return icoMenu;
        }

        public void setIcoMenu(String icoMenu) {
            this.icoMenu = icoMenu;
        }

        @Column(name="nom_opc_menu")
        public String getNomOpcMenu() {
            return nomOpcMenu;
        }

        public void setNomOpcMenu(String nomOpcMenu) {
            this.nomOpcMenu = nomOpcMenu;
        }

        @Column(name="url_ini_menu")
        public String getUrlIniMenu() {
            return urlIniMenu;
        }

        public void setUrlIniMenu(String urlIniMenu) {
            this.urlIniMenu = urlIniMenu;
        }


	@Transient
	public Boolean getInrole() {
		return inrole;
	}

	public void setInrole(Boolean inrole) {
		this.inrole = inrole;
	}

    @Transient
    public boolean isLeaf() {
        return this.options.size()<=0 && this.codPadMenu!=null;
    }
        
    @Transient
    public HashSet<CatMenu> getOptions() {
            return options;
    }

    @Transient
    public List<CatMenu> getOptionsList(){
            List<CatMenu> menuList = new ArrayList<CatMenu>();
            for (CatMenu menu : options) {
                    menuList.add(menu);
            }
            return menuList;
    }

    public void setOptions(HashSet<CatMenu> options) {
            this.options = options;
    }


   @OneToMany(mappedBy="catMenu",fetch= FetchType.EAGER)
   public List<CatUrlMenu> getUrlsMenuList() {
            return urlsMenuList;
    }

    public void setUrlsMenuList(List<CatUrlMenu> urlsMenuList) {
            this.urlsMenuList = urlsMenuList;
    }

    public CatUrlMenu findByUrl(String url){
            for (CatUrlMenu  urlMenu: getUrlsMenuList()) {
                    System.out.println(urlMenu.getUrlMenu());
                    if (urlMenu.getUrlMenu().equals(url)){
                            return urlMenu;
                    }
            }
            return null;
    }

    @ManyToOne
    @JoinColumn(name="COD_PAD_MENU", insertable=false, updatable=false)
    public CatMenu getMenu() {
            return this.menu;
    }

    public void setMenu(CatMenu menu) {
            this.menu = menu;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CatMenu other = (CatMenu) obj;
        if (this.codMenu != other.codMenu && (this.codMenu == null || !this.codMenu.equals(other.codMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.codMenu != null ? this.codMenu.hashCode() : 0);
        hash = 37 * hash + (this.codPadMenu != null ? this.codPadMenu.hashCode() : 0);
        hash = 37 * hash + (this.icoMenu != null ? this.icoMenu.hashCode() : 0);
        hash = 37 * hash + (this.nomOpcMenu != null ? this.nomOpcMenu.hashCode() : 0);
        hash = 37 * hash + (this.urlIniMenu != null ? this.urlIniMenu.hashCode() : 0);
        hash = 37 * hash + (this.menu != null ? this.menu.hashCode() : 0);
        hash = 37 * hash + (this.inrole != null ? this.inrole.hashCode() : 0);
        return hash;
    }

        
	
}
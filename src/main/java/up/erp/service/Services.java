/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import up.erp.server.serviceimpl.*;

/**
 *
 * @author evanl
 */
public class Services {
    
    private static final ProductoService producto = new ProductoServiceImpl();
    private static final MarcaService marca = new MarcaServiceImpl();
//    private static final CulqiService culqiService = new CulqiServiceImpl();
    private static final OrdenVentaService ordenVenta = new OrdenVentaServiceImpl();
    
    private static final PlantillaTransformacionService plantillaTransformacion = new PlantillaTransformacionServiceImpl();
    private static final PersonaService persona = new PersonaServiceImpl();
    private static final DireccionService direccion = new DireccionServiceImpl();
    private static final TransformacionService transformacion = new TransformacionServiceImpl();
    private static final ArticulosService articulo = new ArticuloServiceImpl();
    private static final OrdenService orden = new OrdenServiceImpl();
    private static final AlmacenService almacen = new AlmacenServiceImpl();
    private static final VentasCabService ventasCab = new VentasCabServiceImpl();
    private static final NotaCreditoService notaCredito = new NotaCreditoServiceImpl();
    private static final DocumentoTipoService documentoTipo = new DocumentoTipoServiceImpl();
    private static final TipoNotaCreditoService tipoNotaCredito = new TipoNotaCreditoServiceImpl();
    private static final LoginService login = new LoginServiceImpl();
    private static final NotaPedidoService notaPedido = new NotaPedidoServiceImpl();
    private static final RecibosService recibosService = new RecibosServiceImpl();
    private static final LineaEcommerceService lineaEcommerceService = new LineaEcommerceServiceImpl();
    private static final CuponService cuponService = new CuponServiceImpl();
    private static final PromocionService promoService = new PromocionServiceImpl();
    private static final ImpuestoService impuestoService = new ImpuestoServiceImpl();
    private static final FormaPagoService formaPagoService = new FormaPagoServiceImpl();
    private static final EmpresaService empresaService = new EmpresaServiceImpl();
    private static final PermisosService permisosService = new PermisosServiceImpl();
    private static final RolesService rolesService = new RolesServiceImpl();
    private static final RolPermisoService rolPermisoService = new RolPermisoServiceImpl();
    private static final UsuariosService usuariosService = new UsuariosServiceImpl();
    private static final UsuarioRolService usuarioRolService = new UsuarioRolServiceImpl();
    
    
    public static ProductoService getProducto() {
        return producto;
    }
    
    public static MarcaService getMarca() {
        return marca;
    }

  /*  public static CulqiService getCulqiService() {
        return culqiService;
    }*/

    public static OrdenVentaService getOrdenVenta(){ return  ordenVenta;}

//    public static CulqiService
    
     //Clientes
    private static final PersonaService cliente = new PersonaServiceImpl();

    public static PersonaService getPersona() {
        return cliente;
    }

    public static DireccionService getDireccion() {
        return direccion;
    }
    
    
    
    //Pedidos
    private static final PedidoService pedido = new PedidoServiceImpl();

    public static PedidoService getPedido() {
        return pedido;
    }
    
    //IndexWeb
    private static final IndexWebService index_web = new IndexWebServiceImpl();

    public static IndexWebService getIndexWeb() {
        return index_web;
    }
	

    //UsuarioWeb
    private static final UsuarioWebService usuario_web = new UsuarioWebServiceImpl();

    public static UsuarioWebService getUsuarioWeb() {
        return usuario_web;
    }
    
    //EstadosOrdenVenta
    private static final EstadosOrdenVentaService estadosOrdenVenta = new EstadosOrdenVentaServiceImpl();

    public static EstadosOrdenVentaService getEstadosOrdenVenta() {
        return estadosOrdenVenta;
    }
    
    //Dashboard
    private static final DashboardService dash_board = new DashboardServiceImpl();

    public static DashboardService getDashboardService() {
        return dash_board;
    }
    
    //ReporteService
    private static final ReporteService reporte_Service = new ReporteServiceImpl();
    
    public static ReporteService getReporteService() {
        return reporte_Service;
    }
    
    //LineaEcommerce
    //private static final LineaEcommerceService lineaEcommerce = new LineaEcommerceServiceImpl();

    public static LineaEcommerceService getLineaEcommerce() {
        return lineaEcommerceService;
    }
    
    public static CuponService getCuponService() {
        return cuponService;
    }
    
    public static PromocionService getPromocionService() {
        return promoService;
    }
    
    public static PlantillaTransformacionService getPlantillaTransformacion() {
        return plantillaTransformacion;
    }
    
    public static TransformacionService getTransformacion(){
        return transformacion;
    }
    
    public static ArticulosService getArticulo()
    {
        return articulo;
    }
    
    public static OrdenService getOrden()
    {
        return orden;
    }
    
    public static AlmacenService getAlmacen()
    {
        return almacen;
    }
    
    public static VentasCabService getVentasCab()
    {
        return ventasCab;
    }
    public static NotaCreditoService getNotaCredito()
    {
        return notaCredito;
    }
    
    public static DocumentoTipoService getDocumentoTipo()
    {
        return documentoTipo;
    }
    
    public static TipoNotaCreditoService getTipoNotaCredito()
    {
        return tipoNotaCredito;
    }
    
        
    public static LoginService getLogin()
    {
        return login;
    }
    
    public static NotaPedidoService getNotaPedido()
    {
        return notaPedido;
    }
    
    public static RecibosService getRecibos()
    {
        return recibosService;
    }
    
    public static ImpuestoService getImpuesto(){
        return impuestoService;
    }
    
    public static FormaPagoService getFormaPago(){
        return formaPagoService;
    }
    
    public static EmpresaService getEmpresa(){
        return empresaService;
    }
    
    public static PermisosService getPermiso(){
        return permisosService;
    }
    
    public static RolesService getRoles(){
        return rolesService;
    }
    
    public static UsuariosService getUsuarios(){
        return usuariosService;
    }
    
    public static RolPermisoService getRolPermiso(){
        return rolPermisoService;
    }
    
    public static UsuarioRolService getUsuarioRol(){
        return usuarioRolService;
    }
    
    
    
    
	
}

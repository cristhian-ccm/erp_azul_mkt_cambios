/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.util;

import java.math.BigDecimal;

/**
 *
 * @author etorres
 */
public class Persistence {

    // public static String urlServer =
    // "http://190.117.78.108:8088/upgrade_server_fxx/";//local
    public static String urlServer = "http://192.168.1.150:8088/upgrade_server_fxx/";
    // public static String urlFacturadorSuant =
    // "http://190.117.78.108:8088/FacturadorSunat/index.htm";
    public static String urlFacturadorSuant = "http://192.168.1.150:8090/FacturadorSunat/index.htm";

    public static String urlComprobantesUpgrade = "http://190.117.78.108:8088/upgrade_comprobantes/";
    // public static String urlComprobantesUpgrade =
    // "http://192.168.1.150:8088/upgrade_comprobantes/";
    // public static String urlComisiones =
    // "http://190.117.78.108:8088/comisiones/";
    public static String urlComisiones = "http://192.168.1.150:8088/comisiones/";

    // public static String strUrl = "jdbc:postgresql://" +
    // "192.168.1.130:5433/upgrade2dbPCSmart";
    // public static String strUrl = "jdbc:postgresql://" +
    // "192.168.1.150:9090/upgrade2db";
    // public static String strUrl = "jdbc:postgresql://" +
    // "192.168.1.150:9090/upgradedb";
    public static String strUrl = "jdbc:postgresql://190.119.207.218:9090/bk_up5";

    public static String strDriver = "org.postgresql.Driver";
    public static String strUsr = "postgres";
    public static String strPwd = "rednavedb2015";
    // public static String SUNAT_ARCHIVOS_DATA = "/sunat_archivos/sfs/DATA/";
    public static String SUNAT_ARCHIVOS_FIRMA = "/data0/facturador/FIRMA/";
    public static String SUNAT_ARCHIVOS_REPO = "/data0/facturador/REPO/";
    public static String SUNAT_ARCHIVOS_DATA = "/data0/facturador/DATA/";
    public static String SUNAT_ARCHIVOS_DATA_TEMP = "/data0/facturador/DATA_TEMP/";
    // public static String SUNAT_ARCHIVOS_WEB = "/data0/facturador/DATA/";
    public static String RUC_UPGRADE = "20454043660";
    public static final String CONSTANTE_SITUACION_POR_GENERAR_XML = "01";
    public static final String CONSTANTE_SITUACION_XML_GENERADO = "02";
    public static final String CONSTANTE_SITUACION_ENVIADO_ACEPTADO = "03";
    public static final String CONSTANTE_SITUACION_ENVIADO_ACEPTADO_OBSERVACIONES = "04";
    public static final String CONSTANTE_SITUACION_ENVIADO_ANULADO = "05";
    public static final String CONSTANTE_SITUACION_CON_ERRORES = "06";
    public static final String CONSTANTE_SITUACION_XML_VALIDAR = "07";
    public static final String CONSTANTE_SITUACION_ENVIADO_POR_PROCESAR = "08";
    public static final String CONSTANTE_SITUACION_ENVIADO_PROCESANDO = "09";
    public static final String CONSTANTE_SITUACION_ENVIADO_RECHAZADO = "10";
    // para String
    public static final String SI = "SI";
    public static final String NO = "NO";

    // para el igv
    public static final BigDecimal IGV = BigDecimal.valueOf(1.18);
    // para retenciones
    public static final BigDecimal PORCENTAJE_RETENCION = BigDecimal.valueOf(0.03);
    // para las empresas
    public static final int EMPRESA_GRUPO_UPGRADE_ID = 1;
    public static final int EMPRESA_GRUPO_NOTICIAS_ID = 5;
    // Almacenes traslado simple
    public static final int ALMACEN_A0001 = 1;
    public static final int ALMACEN_C0001 = 3;
    public static final int ALMACEN_AQ001 = 18;
    public static final int ALMACEN_AQ002 = 7;
    public static final int ALMACEN_TRANSITO = 26;
    // Caja
    public static final int CAJA_RETAIL_A0001 = 1;
    public static final int CAJA_SRA_MIRNA_A0001 = 2;
    public static final int CAJA_RETAILQ_AQ0001 = 18;
    public static final int CAJA_SRA_MIRNA_AQ0001 = 19;
    public static final int CAJA_RETAIL_C0001 = 6;

    // para los estados de las tablas
    public static final char ESTADO_BUENO = 'B';
    public static final char ESTADO_ANULADO = 'A';

    // para las ordenes entrada salida
    public static final char MOVIMIENTO_SALIDA = 'S';
    public static final char MOVIMIENTO_ENTRADA = 'E';

    // para las impresiones
    public static final int TRASLADO_SIMPLE = -5;
    public static final int ORDEN_ALMACEN = -4;
    public static final int COTIZACION = -3;
    public static final int GUIA_REMISION = -2;
    public static final int ORDEN_VENTA = -1;
    public static final int RECIBO_CAJA_INGRESO = 0;

    // para los documentos de pago
    public static final int DOCUMENTO_TIPO_FACTURA = 1;
    public static final int DOCUMENTO_TIPO_BOLETA = 3;
    public static final int DOCUMENTO_TIPO_LETRA_CLIENTE = 51;
    public static final int DOCUMENTO_TIPO_REPORTE_SERVICIO_TECNICO = 54;
    public static final int DOCUMENTO_TIPO_COMPROBANTE_ELECTRONICO = 55;

    public static final int FORMA_PAGO_EFECTIVO = 1;
    public static final int FORMA_PAGO_TARJETA_CREDITO = 3;
    public static final int FORMA_PAGO_CREDITO = 4;
    public static final int FORMA_PAGO_MULTIPLE = 6;

    // para las ventas
    public static final int PREVENTA_TIPO_ESTANDAR = 1;
    public static final int PREVENTA_TIPO_MASTER = 2;

    public static final int IMPUESTO_IGV_18 = 2;

    public static int MONEDA_SOLES_ID = 1;
    public static int MONEDA_DOLARES_ID = 2;
    // para el tipo de cod
    public static final String TIPO_AMORTIZACION_LETRA = "L";
    public static final String TIPO_COBRO_ORDEN_VENTA = "O";
    public static final String TIPO_COBRO_VENTA = "V";
    // para los recibos+
    public static final int RECIBO_VISTA = -2;
    public static final int RECIBO_OTROS = -1;
    public static final int RECIBO_TIPO_OTROS = 0;
    public static final int RECIBO_TIPO_COBRO_ORDEN_VENTA = 1;
    public static final int RECIBO_TIPO_CANCELACION_VENTA = 2;
    public static final int RECIBO_TIPO_TRANSFERENCIA_A_CAJA = 3;
    public static final int RECIBO_TIPO_AMORTIZACION_LETRA = 4;
    public static final int RECIBO_TIPO_TRANSFERENCIA_BANCO = 5;
    public static final int RECIBO_TIPO_COMPRA_MONEDA = 6;
    public static final int RECIBO_TIPO_COBRO_CHEQUE = 7;
    public static final int RECIBO_TIPO_PAGO_POR_SERVICIOS = 8;
    public static final int RECIBO_TIPO_CAJA_CHICA = 9;
    public static final int RECIBO_TIPO_DEPOSITO = 10;
    public static final int RECIBO_TIPO_RANSFERENCIA = 11;
    public static final int RECIBO_TIPO_PAGO_POR_CHEQUE = 12;
    public static final int RECIBO_TIPO_PAGO_DE_PRESTAMO = 13;
    public static final int RECIBO_TIPO_PAGO_PROVEEDOR = 14;
    public static final int RECIBO_TIPO_PAGO_BANCOS = 15;
    public static final int RECIBO_TIPO_CIERRE_CAJA = 16;

    public static final int DESTINO_COBRO_INTERNO = 1;
    public static final int DESTINO_COBRO_EXTERNO = 2;

    // para las tarjetas
    public static final int TARJETA_VISA_SOLES = 1;
    public static final int TARJETA_MASTERCARD = 2;

    // cuentas bancarias
    public static final int CUENTA_DESTINO_ID = 4;

    // unidades:
    public static String UNIDAD_KG = "KG";
    public static String UNIDAD_LT = "LT";
    public static String UNIDAD_M3 = "M3";
    public static String UNIDAD_MT = "MT";
    public static String UNIDAD_PZ = "PZ";
    public static String UNIDAD_UN = "UN";
    public static String UNIDAD_GA = "GA";// GALONES

    public static int UNIDAD_UNIDADES = 6;

    // para los clientes:

    public static final int PERSONA_DEFECTO = -1;
    public static final int DIRECCION_DEFECTO = 7;

    public static final int DOCUMENTO_IDENTIDAD_OTROS = 1;
    public static final int DOCUMENTO_IDENTIDAD_DNI = 2;
    public static final int DOCUMENTO_IDENTIDAD_CARNET_EXTRANJERIA = 3;
    public static final int DOCUMENTO_IDENTIDAD_RUC = 4;
    public static final int DOCUMENTO_IDENTIDAD_PASAPORTE = 5;

    public static final char CALIFICACION_LISTA_NEGRA = 'L';
    public static final char CALIFICACION_LEGAL = 'G';
    public static final char CALIFICACION_MOROSO = 'M';
    public static final char CALIFICACION_BUENA = 'B';

    public static final String TRATAMIENTO_SR = "Sr.";
    public static final String TRATAMIENTO_DR = "Dr.";

    // para las personas:
    public static final int TIPO_CLIENTE = 1;
    public static final int TIPO_PROVEEDOR = 2;
    public static final int TIPO_VENDEDOR = 3;
    public static final int TIPO_EMPLEADO = 4;
    public static final int TIPO_PLANILLA = 5;

    // para los mantenimientos
    public static final char MANTENIMIENTO_CORRECTIVO = 'C';
    public static final char MANTENIMIENTO_PREVENTIVO = 'P';
    // para los pagos
    public static String PAGO_DE_COMPRAS = "Registrar Pago de Compra";
    public static String PAGO_DE_PRESTAMO = "Registrar Pago de un Prestamo";
    public static String PAGO_DE_BANCO = "Registrar Pago al Banco";
    public static String REGISTRAR_DEPOSITO_PROVEEDOR = "Registrar Deposito a Proveedor";
    public static String REGISTRAR_SALIDA_EFECTIVO = "Registrar Salida en Efectivo";
    // para los ingresos
    public static String REGISTRAR_INGRESO_EFECTIVO = "Registrar Ingreso en Efectivo";
    /////////////////////////////////////////////////////////////////////////////////////

    // para los ticket
    public static final char ESTADO_ELIMINADO_C = 'E';
    public static final char ESTADO_PENDIENTE_C = 'P';
    public static final char ESTADO_ACEPTADO_C = 'A';
    public static final char ESTADO_REALIZADO_C = 'R';

    public static String ESTADO_ELIMINADO_S = "ELIMINADO";
    public static String ESTADO_PENDIENTE_S = "PENDIENTE";
    public static String ESTADO_ACEPTADO_S = "ACEPTADO";
    public static String ESTADO_REALIZADO_S = "REALIZADO";

    // motivos de traslado
    public static final int MOTIVO_TRASLADO_VENTA = 1;
    public static final int MOTIVO_TRASLADO_ENTRE_ESTABLECIMIENTOS_MISMA_EMPRESA = 6;

    // transient
    public static int BUSCAR_PRODUCTO_CODIGO = 1;
    public static int BUSCAR_PRODUCTO_DESCRIPCION = 2;
    public static int BUSCAR_PRODUCTO_SERIE = 3;
    // roles
    public static int ROL_ROOT = 0;
    public static int ROL_CAJERO = 4;
    public static int ROL_ADMINISTRADOR = 16;
    public static int ROL_ADMINISTRADOR_GENERAL = 20;
    public static int ROL_VENDEDOR_CORPORATIVO = 28;
    public static int ROL_CHOFER = 30;
    public static int ROL_GERENTE = 1;
    public static int ROL_GERENTE_COMERCIAL = 27;
    public static int ROL_SOPORTE_TECNICO = 24;
    public static int ROL_MARQUETING = 25;
    public static int ROL_COMPROBANTES_ELECTRONICOS = 32;
    // para los permisos a la base de datos
    public static int CREAR_PRODUCTOS = 9;
    public static int CREAR_ORDENES_E_S = 15;
    public static int MODIFICAR_ORDENES_E_S = 16;
    public static int LIBERAR_ARTICULOS = 63;

    public static int PER_APROBAR_UTILIDAD_Y_CREDITOS = 32;
    public static int PER_CREAR_ORDENES_COMPRA = 33;
    public static int PER_FINANZAS = 44;
    public static int PER_GERENCIA = 45;

    public static int PER_CAMBIAR_PRODUCTOS_DE_PEDIDOS = 51;
    public static int PER_PAGAR_PROVEEDOR = 52;
    public static int PER_VISUALIZACION_TODAS_VENTAS = 76;
    public static int PER_VISUALIZACION_TODOS_VENDEDORES = 77;
    public static int PER_VISUALIZACION_TODO_LOGISTICA = 78;
    public static int PER_VISUALIZACION_TODOS_CLIENTES = 79;

    public static int PER_VISUALIZACION_PERFIL_VENDEDOR = 80;
    public static int PER_VISUALIZACION_PRODUCTOS_TOP_VENDIDOS = 81;
    public static int PER_VISUALIZACION_ANTIGUEDAD_PRODUCTOS = 82;

    public static int PER_MODIFICAR_INTERES_LETRAS = 83;
    public static int PER_APROBAR_REQUERIMIENTOS_COMPRA = 84;
    // public static int PER_VER_NOTIFICACIONES_VENTA=85;
    public static int PER_EDITAR_DATOS_DE_PERSONA = 86;
    public static int PER_CARTERISAR_VENDEDOR = 87;
    public static int PER_CAMBIAR_VENDEDOR = 88;
    public static int PER_VER_TODO_ORDENES_VENTA = 89;
    public static int PER_VER_COMISIONES = 92;

    // Modificar direccion para reportes
    // Sin Ip Publica//public static String URL = "http://190.117.78.108:8088/";
    public static String URL = "http://192.168.1.150:8088/";
    // public static String URL = "http://190.117.78.108:8088/";//local
    public static String URL_REPORTS = URL + "reportes/upgrade/";
}
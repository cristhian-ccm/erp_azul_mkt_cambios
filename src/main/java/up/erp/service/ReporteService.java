package up.erp.service;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import up.erp.view.exporter.ColumnData;
import up.erp.view.exporter.RowData;

@RemoteServiceRelativePath("ReporteService")
public interface ReporteService extends RemoteService {
	
    public String getExcel(ColumnData[] columns, RowData[] rows, String usuarioId, String folderTemps) throws Exception;

}

package tn.esprit.bean;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import service.StockServiceRemote;


@ManagedBean
@ViewScoped
public class StockChart implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BarChartModel barModel;
	private PieChartModel pieModel2;
    @EJB
	private StockServiceRemote  DocumentServiceRemote;
    
  private List<Object[]> stat  ;
  private List<Object[]> Piestat;
 
    @PostConstruct
    public void init() {
        createBarModels();
        createPieModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    
    private BarChartModel initBarModel() {
    	  List<Object[]> stat = DocumentServiceRemote.StatisticDoc();
    	  
        BarChartModel model = new BarChartModel();
        
 
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
         
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Number of materials by Prix");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Prix");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number Of material");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    private void createPieModels() {
       createPieModel2();
    }
    private void createPieModel2() {
    	List<Object[]> Piestat = DocumentServiceRemote.StatisticDoc();
        pieModel2 = new PieChartModel();
        pieModel2.setTitle("Custom Pie");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        
         
    }
	public List<Object[]> getStat() {
		return stat;
	}

	public void setStat(List<Object[]> stat) {
		this.stat = stat;
	}

	public StockServiceRemote getDocumentServiceRemote() {
		return DocumentServiceRemote;
	}

	public void setDocumentServiceRemote(StockServiceRemote documentServiceRemote) {
		DocumentServiceRemote = documentServiceRemote;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	public List<Object[]> getPiestat() {
		return Piestat;
	}

	public void setPiestat(List<Object[]> piestat) {
		Piestat = piestat;
	}
	
	
 
}
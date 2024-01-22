package dad.geofx.api;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController implements Initializable {

	GeoService service = new GeoService();
	
	GeoServiceIpapi serviceIpapi = new GeoServiceIpapi();
	
	@FXML
    private Label asnLabel;

    @FXML
    private ImageView banderaImage;

    @FXML
    private Label ciudadLabel;

    @FXML
    private Label hostnameLabel;

    @FXML
    private Label ipAddressLabel;

    @FXML
    private TextField ipText;

    @FXML
    private Label ispLabel;

    @FXML
    private Label latitudLabel;

    @FXML
    private Label lenguajeLabel;

    @FXML
    private Label localizacionLabel;

    @FXML
    private Label longitudLabel;

    @FXML
    private Label monedaLabel;

    @FXML
    private Label telefonoLabel;

    @FXML
    private Label tiempoLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private BorderPane view;

    @FXML
    private Label zipLabel;

    @FXML
    void onCheckIp(ActionEvent event) {

    }

	public MainController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

        GeoIpapiResponse ipApiResponse = serviceIpapi.getIpInfo(service.getIpAddress());
		
		ipText.setText(service.getIpAddress());
		latitudLabel.setText(String.format("%.6f", ipApiResponse.getLatitude()));
		longitudLabel.setText(String.format("%.6f", ipApiResponse.getLongitude()));
		localizacionLabel.setText(ipApiResponse.getCountry_name()+" ("+ipApiResponse.getCountry_code()+")");
		Image flags = new Image(getClass().getResourceAsStream("/flag-icons/64x42/" +ipApiResponse.getCountry_code()+ ".png"));
		banderaImage.setImage(flags);
		ciudadLabel.setText(ipApiResponse.getCity());
		zipLabel.setText(ipApiResponse.getZip());
//		lenguajeLabel.setText(ipApiResponse.getLocation().getLanguages());
		tiempoLabel.setText(ipApiResponse.getTime_zone().getCode());
		telefonoLabel.setText(ipApiResponse.getLocation().getCalling_code());
		monedaLabel.setText(ipApiResponse.getCurrency().getName()+" ("+ipApiResponse.getCurrency().getCode()+")");
		ipAddressLabel.setText(ipText.getText());
		ispLabel.setText(ipApiResponse.getConnection().getIsp());
		typeLabel.setText(ipApiResponse.getType());
		asnLabel.setText(ipApiResponse.getConnection().getAsn()+"");
		
		

	}

	public BorderPane getView() {
		return view;
	}

}

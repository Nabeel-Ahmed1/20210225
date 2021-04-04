package haqnawaz.org.database;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonViewAll;
    EditText editName, editAge;
    Switch switchIsActive;
    ListView listViewCustomer;
    ArrayAdapter<CustomerModel> arrayAdapter;
    DBHelper dbHelper;
    List<CustomerModel> allCustomers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CustomerModel[] customerModel = new CustomerModel[1];
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        switchIsActive = findViewById(R.id.switchCustomer);
        listViewCustomer = findViewById(R.id.listViewCustomer);

        RefreshData();
        buttonAdd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                try {
                    customerModel[0] = new CustomerModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchIsActive.isChecked());

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                boolean b = dbHelper.addCustomer(customerModel[0]);
                if(b==true){
                    //Toast.makeText(MainActivity.this, customerModel[0].toString(), Toast.LENGTH_SHORT).show();
                    RefreshData();
                }

            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RefreshData();
                //Toast.makeText(MainActivity.this, "View all clicked", Toast.LENGTH_SHORT).show();
            }
        });

        listViewCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerModel n = new CustomerModel();
                n = allCustomers.get(position);
                int findID = n.getId();

                dbHelper = new DBHelper(MainActivity.this);
                dbHelper.deleteCustomer(findID);
                RefreshData();
            }
        });

    }
        public void RefreshData() {
            dbHelper = new DBHelper(MainActivity.this);
            allCustomers = dbHelper.getAllRecords();
            arrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, allCustomers);
            listViewCustomer.setAdapter(arrayAdapter);
            CustomerModel customerModel = new CustomerModel();
    }
}
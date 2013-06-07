package com;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;



/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")

public class MyVaadinUI extends UI
{

    private VerticalLayout layout = new VerticalLayout();
    private FormLayout form = new FormLayout();
    private Button button = new Button("Ok");
    private FormLayout reader=new FormLayout() ;
    private Label label=new Label("Employee Details") ;


    @Override
    protected void init(VaadinRequest request) {
        initLayout();
    }
    private void initLayout() {

        layout.setMargin(true);
        setContent(layout);


        form.setCaption("Employee Details ");
        PropertysetItem item = new PropertysetItem();
        item.addItemProperty("Name",  new ObjectProperty<String>(""));
        item.addItemProperty("Address", new ObjectProperty<String>(""));

        ComboBox combobox = new ComboBox("Sex");
        combobox.setInvalidAllowed(true);
        combobox.setNullSelectionAllowed(false);
        combobox.addItem("Male");
        combobox.addItem("Female");
        item.addItemProperty("Age",  new ObjectProperty<String>(""));
        item.addItemProperty("Email",  new ObjectProperty<String>(""));
        item.addItemProperty("Mobile No",  new ObjectProperty<String>(""));


         Form form = new Form();
        final Form reader=new Form();
        form.setCaption("Fill Your Details");
        form.setItemDataSource(item);
        reader.setItemDataSource(item);
        reader.setCaption("Your registation details");
        reader.setReadOnly(true);


        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {

                Label message=new Label("You are Registered") ;
                layout.addComponent(message);
                layout.addComponent(reader);

            }
        });
        layout.addComponent(form);

        final RichTextArea area = new RichTextArea();
        area.setValue("Add more details here");
        layout.addComponent(area);

        layout.addComponent(button);

         }

    }














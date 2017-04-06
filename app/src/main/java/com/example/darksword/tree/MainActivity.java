package com.example.darksword.tree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity
{
    private EditText ETenterval;
    private TextView TVdisplay;
    private Tree tree = new Tree();
    private String sillyString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ETenterval = (EditText)this.findViewById(R.id.ETenterVal);
        this.TVdisplay = (TextView)this.findViewById(R.id.TVdisplay);
    }
    public void processButtonPressed (View v)
    {
        String s = ETenterval.getText().toString();
                //String.valueOf(ETenterval);
        //String alpha = "4";
        int b = parseInt(s);
        //int b = parseInt(ETenterval.toString());
        this.tree.treeRecursion(b);
        sillyString = sillyString + b;
        TVdisplay.setText(sillyString);
    }
    public String stringifyThatTree(Tree t)
    {
        Tree runner = t;
        String concatonationIsFun = "";
        while(runner.getPayload() != -1)
        {
            concatonationIsFun = concatonationIsFun + runner.getPayload();
            runner = runner.getNextTree();
        }
        return "";
    }
}

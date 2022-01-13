package com.example.theprince.epicgames;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Recycled_View extends AppCompatActivity {

    Spinner sp;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycled__view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp = findViewById(R.id.spinner);
        String names[] = {"All","Sport","Adventure","Racing","Action","Fighting","Horror"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        sp.setAdapter(adapter);

        ////////////////////////////////////////////////////////
        final ArrayList<Set_Get_Data> sport = new ArrayList<>();

        sport.add(new Set_Get_Data("Fifa 18","Powered by Frostbite, FIFA 18 blurs the line between the virtual " +
                "and real worlds, bringing to life the players, teams and atmospheres of The World’s Game.","200$",R.drawable.fifap));
        //1
        sport.add(new Set_Get_Data("Pes 18", "‘Where Legends Are Made’ encapsulates the return of PES, with an unparalleled gameplay experience.", "189$", R.drawable.pesp));
        //2
        sport.add(new Set_Get_Data("WWE 2K18","The biggest video game franchise in WWE history is back with WWE 2K18! Featuring cover Superstar Seth Rollins," +
                " WWE 2K18 promises to bring you closer to the ring than ever before with hard-hitting action, stunning graphics","179$",R.drawable.wwep));
        //3
        sport.add(new Set_Get_Data("F1 2017", "Win the 2017 World Championship, break every record in the fastest ever F1 cars, and race some of the most iconic " +
                "F1 cars of the last 30 years.", "99$", R.drawable.f1p));
        //4
        sport.add(new Set_Get_Data("FootBall Manger 17", "Take control of your favourite football team in Football Manager 2017, the most realistic and immersive " +
                "football management game to date. It’s the closest thing to doing the job for real!", "89$", R.drawable.footp));
        //5
        sport.add(new Set_Get_Data("Tennis World Tour", "Play as one of the 30 best tennis players in the world: Roger Federer, Angelique Kerber," +
                " Stan Wawrinka and many of the sport’s legends.", "79$", R.drawable.tennisp));
        //6
        //6 sport games
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final ArrayList<Set_Get_Data> Adventure = new ArrayList<>();

        Adventure.add(new Set_Get_Data("Assassins Creed III","Assassin’s Creed 3 Overview\n" +
                "Assassin’s Creed III is an action adventure game which is developed under the banner of Ubisoft" +
                " Montreal for Microsoft Windows and other playing consoles.","159$",R.drawable.assassinsp));
        //1
        Adventure.add(new Set_Get_Data("Battle Field 4","Battlefield 4 Overview\n" +
                "Welcome to Battlefield 4 is an impressive first person shooting game. " +
                "This game was developed by EA DICE for Microsoft Windows and publish under the banner of Electronic Arts","189$",R.drawable.battle_field_icon));
        //2
        Adventure.add(new Set_Get_Data("Far Cry 4","Far Cry 4 PC Game 2014 Overview\n" +
                "Far Cry 4 PC Game is developed by Ubisoft Montreal and published by Ubisoft","220$",R.drawable.far_cry_icon));
        //3
        Adventure.add(new Set_Get_Data("Rise Of The Tomb Raider","Rise Of The Tomb Raider PC Game 2016 Overview\n" +
                "Rise of the Tomb Raider is developed by Crystal Dynamics and is published under the banner of Square Enix. This game was released on 28th January, 2016. You can also download Tomb Raider 2.","275$",R.drawable.tomp_rider_icon));
        //4
        Adventure.add(new Set_Get_Data("Call of Duty Black Ops","Call of Duty Black Ops Overview\n" +
                "The famous series of Call of Duty comes with a new game. Call of Duty Black Ops 1","175$",R.drawable.callp));
        //5
        Adventure.add(new Set_Get_Data("Max Payne 3","  Max Payne 3 Overview\n" +
                "This game is published by Rockstar Games. Max Payne 3 has stunning sound and graphic effects. Max Payne 3 is the third game in the Max Payne series","66$",R.drawable.maxp));
        //6
        Adventure.add(new Set_Get_Data("Resident Evil 6","Resident Evil 6 Overview\n" +
                "Player will also experience dramatic horror in this game. Resident Evil 6 is published by Capcom.","41$",R.drawable.residentp));
        //7
        Adventure.add(new Set_Get_Data("Sniper Elite 4","Sniper Elite 4 PC game 2017 Overview\n" +
                "Sniper Elite 4 has been developed and published under the banner of Rebellion. This game was released on 14th February","59$",R.drawable.sniper_icon));
        //8
        Adventure.add(new Set_Get_Data("Prototype 2","Prototype 2 Overview\n" +
                "Welcome to Prototype 2 is the most exciting open world action-adventure video game which has been publish under the banner of Activision.","35$",R.drawable.protop));
        //9
        //9 adventure games
        ///////////////////////////////////////////////////////////////////////////
        final ArrayList<Set_Get_Data> Horror = new ArrayList<>();

        Horror.add(new Set_Get_Data("The Evil Within","The Evil Within PC Game Overview\n" +
                "The Evil Within is one of very exciting games. We categorized this game in survival games. It is a game in which you will also enjoy some horror moments." +
                " This game is developed by Tango Game works and published by Bethesda Softworks.", "119$", R.drawable.the_evil_within_icon));
        //1
        Horror.add(new Set_Get_Data("Outlast 2","Outlast 2 PC Game 2017 Overview\n" +
                "Outlast 2 is the sequel to the acclaimed survival horror game Outlast. Set in the same universe as the first game","99$",R.drawable.outlast_icon));
        //2
        Horror.add(new Set_Get_Data("Silent Hill 4","Silent Hill 4 The Room PC Game 2004 Overview\n" +
                "Silent Hill 4 The Room is a survival horror game. It is developed and published under the banner of Konami for Microsoft Windows.","29$",R.drawable.silent_hill_icon));
        //3
        Horror.add(new Set_Get_Data("The Walking Dead A New Frontier Episode 4","The Walking Dead A New Frontier Episode 4 PC Game 2017 Overview\n" +
                "When family is all you have left…how far will you go to protect it? After society was ripped apart by undead hands","249$",R.drawable.the_walking_dead_icon));
        //4
        Horror.add(new Set_Get_Data("Lethe Episode One","Lethe Episode One PC Game 2016 Overview\n" +
                "Lethe-Episode One is developed under the banner of KoukouStudios and Faber Interactive.","69$",R.drawable.lethe_icon));
        //5
        //5 horror games
        ///////////////////////////////////////////////////////////////////////////
        final ArrayList<Set_Get_Data> Fightting = new ArrayList<>();

        Fightting.add(new Set_Get_Data("Mortal Kompat XL", "Mortal Kombat XL PC Game 2016 Overview\n" +
                "Mortal Kombat XL has been developed by NetherRealm Studios and QLOC. This game was released on 4th October, 2016.", "199$", R.drawable.mkxl_icon));
        //1
        Fightting.add(new Set_Get_Data("Guilty Gear Xrd","Guilty Gear Xrd PC Game 2015 Overview\n" +
                "Guilty Gear Xrd is developed and published under the banner of Arc System Works.","89$",R.drawable.guilty_gear_icon));
        //2
        Fightting.add(new Set_Get_Data("Tekken 6","Tekken 6 PC Game Overview\n" +
                "Tekken 6 is a fighting game that has been developed by Namco Bandai. Tekken 6 is the 7th installment of the world acclaimed Tekken series. ","15$",R.drawable.tekken_icon));
        //3
        Fightting.add(new Set_Get_Data("Injustice Gods Among Us","Injustice Gods Among Us PC Game Overview\n" +
                "Injustice: Gods Among Us is a fighting game. This game is based on the characters developed by DC comics and it was developed under the banner of NetherRealm Studios.","59$",R.drawable.injustice_icon));
        //4
        //4 fighting games
        //////////////////////////////////////////////////////////////////////////////////
        final ArrayList<Set_Get_Data>  Racing = new ArrayList<>();

        Racing.add(new Set_Get_Data("Need For Speed payback","Need for Speed™, one of the world’s bestselling video game franchises" +
                " returns with a vengeance in the new Need for Speed Payback.","259$",R.drawable.nfsp));
        //1
        Racing.add(new Set_Get_Data( "MX vs ATV All Out", "All Terrain, All Vehicles, All You! MX vs ATV All Out is the complete off-road racing and lifestyle experience!",
                "99$", R.drawable.mxp));
        //2
        Racing.add(new Set_Get_Data("Moto GP 18", "Become the star of the 2018 MotoGP season! Pursue your career as a professional rider starting from the Red Bull MotoGP Rookies Cup up to the Premier class of the MotoGP",
                "159$", R.drawable.motop));
        //3
        Racing.add(new Set_Get_Data("Forza Horizon 3", "THIS IS YOUR HORIZON You’re in charge of the Horizon Festival. Customize everything, hire and fire your friends, and explore Australia in over 350 of the world’s greatest cars.",
                "399$", R.drawable.forzahorizon3p));
        //4
        Racing.add(new Set_Get_Data("drift tunner 2019", "Do you like Drifting? Are you a fan of JDM Style? You dream to fall sideways but you have not picked up a drift car yet? – This game is for you!",
                "25$", R.drawable.driftp));
        //5
        //5 racing games
        ////////////////////////////////////////////////////////////////////////////////////////////
        final ArrayList<Set_Get_Data> Action = new ArrayList<>();

        Action.add(new Set_Get_Data("GTA V","GTA 5 is developed by Rockstar North and is published under the banner of Rockstar Games. The release date of this game is 14th April 2015." +
                " GTA V game can be played either by first person or by third person perspective.","359$",R.drawable.gtap));
        //1
        Action.add(new Set_Get_Data("Titan fall 2", "Call down your Titan and get ready for an exhilarating first-person shooter experience in Titan fall™ 2! The sequel introduces a new single player campaign that explores the bond between Pilot and Titan.",
                "99$", R.drawable.titanp));
        //2
        Action.add(new Set_Get_Data("Watch Dogs 2", "Watch Dogs 2 has been developed and published under the banner of Ubisoft. This game was released on 29th November, 2016.",
                "149$", R.drawable.watchp));
        //3
        Action.add(new Set_Get_Data("Outbreak The Nightmare Chronicles Chapter 2", "Outbreak The Nightmare Chronicles Chapter 2 Free Download PC Game setup in single direct link for Windows. It is an amazing action, adventure and indie game.",
                "29$", R.drawable.outp));
        //4
        //4 action games
        /////////////////////
        ///6+9+5+4+5+4=33 game available
        /////////////////////////////////////////////////////////////////////////////////
        final ArrayList<Set_Get_Data> All = new ArrayList<>();
        for (int i = 0; i < Adventure.size(); i++) {
            if (i < sport.size())
                All.add(sport.get(i));

            All.add(Adventure.get(i));

            if (i < Action.size())
                All.add(Action.get(i));

            if (i < Horror.size())
                All.add(Horror.get(i));

            if (i < Racing.size())
                All.add(Racing.get(i));

            if (i < Fightting.size())
                All.add(Fightting.get(i));
        }
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adpter adpter = new Adpter(All , this );    ///add this////
        recyclerView.setAdapter(adpter);

        final Adpter[] a = new Adpter[1];
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (sp.getSelectedItemPosition())
                {
                    case 0 : a[0] = new Adpter(All , Recycled_View.this);        recyclerView.setAdapter(a[0]);    break;
                    case 1 : a[0] = new Adpter(sport , Recycled_View.this);      recyclerView.setAdapter(a[0]);    break;
                    case 2 : a[0] = new Adpter(Adventure , Recycled_View.this);  recyclerView.setAdapter(a[0]);    break;
                    case 3 : a[0] = new Adpter(Racing , Recycled_View.this);     recyclerView.setAdapter(a[0]);    break;
                    case 4 : a[0] = new Adpter(Action , Recycled_View.this);     recyclerView.setAdapter(a[0]);    break;
                    case 5 : a[0] = new Adpter(Fightting , Recycled_View.this);  recyclerView.setAdapter(a[0]);    break;
                    case 6 : a[0] = new Adpter(Horror , Recycled_View.this);     recyclerView.setAdapter(a[0]);    break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.personSetting){
            intent = new Intent(this,signUp.class);

            /////To Update The EditInfo////
            DataBase db = new DataBase(Recycled_View.this);
            Cursor c = db.getSpecifiedRow_users("1");
            c.moveToNext();
            db.update_editInfo(c.getString(2),c.getString(3),"1");

            startActivity(intent);
        }
        else if(item.getItemId() == R.id.logOut){
            intent = new Intent(this,login.class);

            /////To Update The Active////
            DataBase db = new DataBase(Recycled_View.this);
            Cursor c = db.getSpecifiedRow_users("1");
            c.moveToNext();
            db.update_active(c.getString(2),c.getString(3),"0");

            startActivity(intent);
            finish();
        }
        else if(item.getItemId() == R.id.showBuying){
            intent = new Intent(this,Show_Buying.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}


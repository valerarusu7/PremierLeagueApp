package com.example.premierleagueapp.requests.clients;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.CompetitionStandings;
import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.requests.ServiceGenerator;
import com.example.premierleagueapp.requests.TableEndpoints;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableAPIClient {
    private MutableLiveData<ArrayList<Table>> standingsLiveData = new MutableLiveData<>();
    private Application application;

    public TableAPIClient(Application application) {
        this.application = application;
    }

    public LiveData<ArrayList<Table>> getTableLiveData() {
        TableEndpoints endpoints = ServiceGenerator.getTableEndpoints();

        Call<CompetitionStandings> call = endpoints.getTable(Token.getTOKEN());
        call.enqueue(new Callback<CompetitionStandings>() {
            @Override
            public void onResponse(@NonNull Call<CompetitionStandings> call, @NonNull Response<CompetitionStandings> response) {
                CompetitionStandings apiStandings = response.body();
                assert apiStandings != null;
                if (response.isSuccessful()) {
                    setImages(apiStandings.getStandings().get(0).getTable());
                    standingsLiveData.setValue(apiStandings.getStandings().get(0).getTable());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CompetitionStandings> call, @NonNull Throwable t) {
                System.out.println("Failed to load the data from  : TABLE");
                System.out.println(t.getMessage());

            }
        });
        return standingsLiveData;
    }

    public void setImages(ArrayList<Table> teams) {
        for (Table table : teams) {
            switch (table.getTeam().getName()) {
                case "Arsenal FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Farsenal_fc.png?alt=media&token=d8b181f3-45eb-40f0-988f-90f5fcbd53e2");
                    break;
                case "Aston Villa FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Faston_villa.png?alt=media&token=ad096aad-cbb4-4db9-b656-4ed024280342");
                    break;
                case "Chelsea FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fchelsea.png?alt=media&token=a108d045-79a2-44eb-be72-0a6e7cf95cda");
                    break;
                case "Everton FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Feverton.png?alt=media&token=3f34fa0d-60c5-41cb-8e4b-d657269dd919");
                    break;
                case "Liverpool FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fliverpool.png?alt=media&token=48b746f5-eba2-4eec-a49a-c6523dc9199d");
                    break;
                case "Manchester City FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fmanchester_city.png?alt=media&token=304da8b3-6b12-496b-9e59-5361abeafe0b");
                    break;
                case "Manchester United FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fmanchester_united.png?alt=media&token=35dad674-d5e9-4122-a864-9ef955293594");
                    break;
                case "Newcastle United FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fnewcastle_united.png?alt=media&token=235e74a4-9598-456c-9309-129f8e5f88a1");
                    break;
                case "Norwich City FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fnorwich_city.png?alt=media&token=4e4f76b6-0054-4a18-995f-ae2c93a6c12a");
                    break;
                case "Tottenham Hotspur FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Ftottenham_hotspur.png?alt=media&token=a8628347-3491-4955-ac7b-f0cecef7f837");
                    break;
                case "Wolverhampton Wanderers FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fwolves.png?alt=media&token=136319b6-20f1-4a27-be42-5e1cc8c27eb6");
                    break;
                case "Burnley FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fburnely.png?alt=media&token=89c9d3f4-b5c5-4aa7-a3db-94949653708e");
                    break;
                case "Leicester City FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fleicester_city.png?alt=media&token=5915003e-1484-476a-8549-153c757c0cb5");
                    break;
                case "Southampton FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fsouthampton.png?alt=media&token=a641aea0-a8f8-40ff-8e74-332949822a3e");
                    break;
                case "Watford FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fwatford.png?alt=media&token=526fb061-4280-4873-a948-efd4fce78c8f");
                    break;
                case "Crystal Palace FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fcrystal_palace.png?alt=media&token=f13f884e-dc06-4778-b1ff-7c0a2a963971");
                    break;
                case "Sheffield United FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fsheffield_united.png?alt=media&token=1e0e4973-ec98-4c3d-a861-fcdbada421b6");
                    break;
                case "Brighton & Hove Albion FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fbrighton.png?alt=media&token=bfd39280-04db-465c-8f74-b1d9ec7666f5");
                    break;
                case "West Ham United FC":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fwest_ham.png?alt=media&token=69cd0056-8744-4fe7-b7b4-223657d311fb");
                    break;
                case "AFC Bournemouth":
                    table.getTeam().setCrestUrl("https://firebasestorage.googleapis.com/v0/b/androidpremierleagueapp.appspot.com/o/images%2Fbournemonth.png?alt=media&token=5c21807e-225f-4822-ba64-185d6bfcba08");
                    break;
            }
        }
    }
}

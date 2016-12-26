package com.boardgame.service.script

import groovy.transform.CompileStatic
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner.class)
@CompileStatic
public class ScriptSeviceTest {

    @Autowired
    ScriptService me;

    @Test
    public void test() throws IOException {
        String evaluationScript =
                "var earnings = stock.getNetIncome() * 10; " +
                        "earnings += (stock.getTotalCash() - stock.getTotalDebt()); " +
                        "if (earnings > stock.getMarketCap()) { " +
                        "    stock.setUndervalued(true); " +
                        "} else { " +
                        "    stock.setUndervalued(false); " +
                        "} ";

        Stock stock = new Stock();
        stock.setNetIncome(10.0);
        stock.setTotalCash(100.0);
        stock.setTotalDebt(0.0);
        stock.setMarketCap(150.0);

        me.runScript(evaluationScript, ['stock':stock] as Map<String, Object>);

        Assert.assertTrue(stock.isUndervalued());
    }

}

class Stock {
    double netIncome, totalCash, totalDebt, marketCap;
    boolean undervalued;

    public boolean isUndervalued() {
        return undervalued;
    }

    public void setUndervalued(boolean undervalued) {
        this.undervalued = undervalued;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getNetIncome() {

        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }
}

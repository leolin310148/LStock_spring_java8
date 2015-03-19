package me.leolin.business.transformer;

import me.leolin.App;
import me.leolin.dao.StockPriceDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author leolin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class StockTransformerTest {

    @Autowired
    private StockPriceDao stockPriceDao;

    @Test
    @Transactional
    public void testPriceInfoTransform() throws Exception {
        stockPriceDao.findAll().stream().map(StockTransformer::priceEntityToDto);
    }
}
package org.thehecklers.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thehecklers.entity.Quote;
import org.thehecklers.repository.QuoteRepo;
import org.thehecklers.entity.QuoteSource;
import org.thehecklers.repository.QuoteSourceRepo;

import javax.annotation.PostConstruct;

/**
 * Created by markheckler on 12/31/15.
 */
@Service
public class DataLoader {
    private QuoteRepo quoteRepo;
    private QuoteSourceRepo quoteSourceRepo;

    @Autowired
    public DataLoader(QuoteRepo quoteRepo, QuoteSourceRepo quoteSourceRepo) {
        this.quoteRepo = quoteRepo;
        this.quoteSourceRepo = quoteSourceRepo;
    }

    @PostConstruct
    private void initData() {
        QuoteSource markTwain = new QuoteSource("Samuel Langhorne Clemens", "Mark Twain, American author and humorist");
        quoteSourceRepo.save(markTwain);

        QuoteSource steveJobs = new QuoteSource("Steve Jobs", "Computing pioneer and visionary");
        quoteSourceRepo.save(steveJobs);

        QuoteSource derekSivers = new QuoteSource("Derek Sivers", "Founder of CD Baby");
        quoteSourceRepo.save(derekSivers);

        QuoteSource winstonChurchill = new QuoteSource("Winston Churchill", "British Statesman; Prime Minister, UK (1940-1945, 1951-1955)");
        quoteSourceRepo.save(winstonChurchill);

        QuoteSource markZuckerberg = new QuoteSource("Mark Zuckerberg", "Founder of Facebook");
        quoteSourceRepo.save(markZuckerberg);

        Quote mt = new Quote("Do the right thing. It will gratify some people and astonish the rest.", "",
                quoteSourceRepo.findOne(markTwain.getId()));
        quoteRepo.save(mt);

        Quote sj = new Quote("Don't let the noise of others' opinions drown out your own inner voice. Have the courage to follow your own heart and intuition.", "",
                quoteSourceRepo.findOne(steveJobs.getId()));
        quoteRepo.save(sj);

        Quote ds = new Quote("The most brilliant idea, with no execution, is worth $20.", "",
                quoteSourceRepo.findOne(derekSivers.getId()));
        quoteRepo.save(ds);

        Quote wc = new Quote("My most brilliant achievement was my ability to be able to persuade my wife to marry me.", "",
                quoteSourceRepo.findOne(winstonChurchill.getId()));
        quoteRepo.save(wc);

        Quote mz = new Quote("Move fast and break things. Unless you are breaking stuff, you are not moving fast enough.", "",
                quoteSourceRepo.findOne(markZuckerberg.getId()));
        quoteRepo.save(mz);
    }
}

package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository

    HeroRepository heroRepository;

    @Before
    public void setUp(){
        heroRepository = new HeroRepository();

    }

    @Test
    public void testMethodGetCountReturnsValidInfo(){
        int getCount = heroRepository.getCount();
        Assert.assertEquals(0,getCount);
        Hero hero = new Hero("Name",1);
        heroRepository.create(hero);
        getCount = heroRepository.getCount();
        Assert.assertEquals(1,getCount);
    }


    @Test (expected = NullPointerException.class)
    public void testCreateMethodThrowsExceptionForNullHero(){
        heroRepository.create(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateMethodThrowsExceptionForAddingSameHeroTwice(){
        Hero hero = new Hero("name",1);
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void testCreateMethodAddsHeroSuccessfully(){
        Hero hero = new Hero("name", 1);
        Assert.assertEquals(0,heroRepository.getCount());
        heroRepository.create(hero);
        Assert.assertEquals(1,heroRepository.getCount());
        Assert.assertEquals(heroRepository.getHero("name"),hero);
    }


    @Test (expected = NullPointerException.class)
    public void testRemoveMethodThrowsExceptionForNullName(){
        heroRepository.remove(null);
    }

    @Test
    public void testRemoveMethodReturnsTrueAndRemovesHero(){
        Hero hero = new Hero("Name",1);
        heroRepository.create(hero);
        Assert.assertEquals(1,heroRepository.getCount());
        heroRepository.remove("Name");
        Assert.assertEquals(0,heroRepository.getCount());
    }

    @Test
    public void testRemoveMethodReturnsFalseForInvalidName(){
        Assert.assertFalse(heroRepository.remove("Invalid Name"));
    }

    //getHeroWithHighestLevel returns correct hero

    @Test
    public void testGetHeroWithHighestLevelReturnsNullForEmptyRepository(){
        Assert.assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsCorrectHero(){
        Hero lowestLevelHero = new Hero("Lowest level hero",1);
        Hero highestLevelHero = new Hero("Highest level hero",100);
        Hero lowerLevelHero = new Hero("Lower level hero",5);
        heroRepository.create(lowerLevelHero);
        heroRepository.create(highestLevelHero);
        heroRepository.create(lowestLevelHero);

        Assert.assertEquals(highestLevelHero,heroRepository.getHeroWithHighestLevel());

    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetHeroesMethodReturnsUnmodifiableCollection(){
        heroRepository.getHeroes().clear();

    }

}

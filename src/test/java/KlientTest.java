import org.junit.Test;

import static org.junit.Assert.*;

public class KlientTest {

    @Test
    public void testKlient() {
        //given
        Klient klient = new Klient();

        //when
        klient.setAdres("Błotna");
        klient.setImie("Tomek");
        klient.setNazwisko("Aaaa");
        klient.setPesel(12345678911l);
        //then
        assertEquals(false, klient.isFirma());
        assertEquals("Tomek", klient.getImie());
        assertEquals("Aaaa", klient.getNazwisko());
        assertEquals(12345678911l, klient.getPesel());
    }

    @Test
    public void testFirma() {
        //given
        Klient firma = new Klient();
        //when
        firma.setFirma(true);
        firma.setNazwaFirmy("Kogucik");
        firma.setNip(1234567891);
        //then
        assertEquals(true, firma.isFirma());
        assertEquals("Kogucik", firma.getNazwaFirmy());
        assertEquals(1234567891, firma.getNip());
    }

    @Test
    public void testKonstruktoraPoprawnyPesel() {
        //given
        long pesel = 27092924229L;
        //when
        Klient klient = new Klient("Jan", "Kowalski", pesel, "ulica Błotna");

        //then
        assertEquals(pesel, klient.getPesel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKonstruktoraNiePoprawnyPesel() {
        //given
        long pesel = 17092924229L;

        //when
        Klient klient = new Klient("Jan", "Kowalski", pesel, "ulica Błotna");

        //then
    }

    @Test
    public void testKonstruktoraZPoprawnymNipem() {
        //given
        long nip = 7575820010L;
        //when
        Klient klient = new Klient("Kogucik", nip, "Błotna");

        //then
        assertEquals(nip, klient.getNip());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKonstruktoraZNiepoprawnymNipem() {
        //given
        long nip = 1575820010L;
        //when
        Klient klient = new Klient("Kogucik", nip, "Błotna");

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullowegoImienia() {
        //given
        String imie = null;
        //when
        Klient klient = new Klient(imie, "Kowalski", 54021422963l, "Błotna");

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPustegoImienia() {
        //given
        String imie = "";
        //when
        Klient klient = new Klient(imie, "Kowalski", 54021422963l, "Blotna");
        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPustegoAdresu() {
        //given
        String adres = "";
        //when
        Klient klient = new Klient("Kogucik", 1547921397L, adres);
        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullowejNazwyFirmy() {
        //given
        String firma = null;
        //when
        Klient klient = new Klient(firma, 1547921397L, "Błotna");
        //then

    }

    @Test(expected = IllegalArgumentException.class)
    public void testPustegoNazwiska() {
        //given
        String nazwisko = "";
        //when
        Klient klient = new Klient("Jan", nazwisko, 54021422963l, "Błotna");

        //then


    }
}
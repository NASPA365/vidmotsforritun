6. 
    Búðu til ferd-view.fxml og FerdController. 
    Í því viðmótstré skaltu sýna upplýsingar um eina ferð og hafa hnapp til að fara aftur í Aðal.  
    FerdController útfærir (implements) GognInterface<Ferd>.

7. 
    Í AdalController skaltu útfæra aðgerðina onSkoda sem er tengd við Skoda hnappinn.
    Þar nærðu í valda ferð, f, úr ListView hlutnum, kallar á ViewSwitcher 
    til að skipta yfir í FERD view og sendir ferðina (f) inn í FerdController í 
    switchTo (View.FERD, false, f)

8. 
Í FerdController skaltu útfæra aðferð (skilgreind í GognInterface), setGogn (Ferd f),  
sem tekur við Ferd hlut og uppfærir viðmótið með binding við viðmótshlutina, 
ekki með beinum setText() í kóðanum.  Bættu einnig við handler sem skiptir aftur yfir í Aðal view.

9. 
(Heima) Prófaðu forritið vel. Athugaðu að Skoða sé óvirkur þegar ekkert er valið,
að skipting milli viðmótstrjáa virki í báðar áttir og að rétt ferð birtist í Ferð view. 
Skoðaðu a.m.k. 2 ferðir. 
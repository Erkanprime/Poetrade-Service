# Poetrade-Service
Det här projektet är en "webbskrapare" som indexar spelet "Path of Exile's" forum, se t.ex. https://www.pathofexile.com/forum/view-forum/hardcore-trading-shops. 
Path of exile är ett ARPG-spel där en stor del av spelet går ut på att sälja/köpa saker till sina karaktärer. Detta gör man främst genom så kallade
"Shops" som man skapar på forumet. En Shop innehåller alla saker man hittat och vill sälja.

Anledningen till att man lägger upp Shops på forumet är för att sakerna ska sedan indexeras av tredje-parts tjänster som gör det möjligt att söka på saker via deras Gui.
(Path of exile's forum har ingen sökfunktion).
I.o.m att spelet inte har något publikt Api(detta har senare implementerats?) så måste man använda sig av webbskrapning för att hämta hem och spara alla Shopsen som folk lägger upp.

Detta gör jag genom ett schemalagt spring job som läser in alla uppdaterade shopsen och sparar ner dem till en databas.
Sedan har jag ett Gui byggt med Angular där jag presenterar ett dynamiskt formulär där man kan göra avancerade sökningar via ett forumulär.

Problem som dykt upp/tagit tid har varit parsningen av Jsondatat som jag läser in via webbskrapningen. Datat är ibland inkonsistent och svårt att förstå så en stor del av projektet har varit att försöka nå 100% korrekt inläsning av data.

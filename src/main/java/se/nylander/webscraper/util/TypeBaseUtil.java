package se.nylander.webscraper.util;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by erik.nylander on 2016-04-29.
 */
public enum TypeBaseUtil {

    Bow("Bow", new String[] { "Assassin Bow", "Bone Bow", "Citadel Bow", "Composite Bow", "Compound Bow", "Crude Bow", "Death Bow",
            "Decimation Bow", "Decurve Bow", "Golden Flame", "Grove Bow", "Harbinger Bow", "Highborn Bow", "Imperial Bow", "Ivory Bow",
            "Long Bow", "Maraketh Bow", "Ranger Bow", "Recurve Bow", "Reflex Bow", "Royal Bow", "Short Bow", "Sniper Bow", "Spine Bow",
            "Steelwood Bow", "Thicket Bow"

    }),

    Claw("Claw",
            new String[] { "Awl", "Blinder", "Cat's Paw", "Double Claw", "Eagle Claw", "Eye Gouger", "Fright Claw", "Gemini Claw", "Gouger",
                    "Great White Claw", "Gut Ripper", "Hellion's Paw", "Imperial Claw", "Nailed Fist", "Noble Claw", "Prehistoric Claw",
                    "Sharktooth Claw", "Sparkling Claw", "Terror Claw", "Thresher Claw", "Throat Stabber", "Tiger's Paw", "Timeworn Claw",
                    "Twin Claw", "Vaal Claw"

            }),
    Dagger("Dagger", new String[] { "Ambusher", "Boot Blade", "Boot Knife", "Butcher Knife", "Carving Knife", "Copper Kris", "Demon Dagger",
            "Ezomyte Dagger", "Fiend Dagger", "Flaying Knife", "Glass Shank", "Golden Kris", "Gutting Knife", "Imp Dagger",
            "Imperial Skean", "Platinum Kris", "Poignard", "Prong Dagger", "Royal Skean", "Sai", "Skean", "Skinning Knife",
            "Slaughter Knife", "Stiletto", "Trisula"

    }),
    OneHandAxe("One Hand Axe",
            new String[] { "Arming Axe", "Boarding Axe", "Broad Axe", "Butcher Axe", "Ceremonial Axe", "Chest Splitter", "Cleaver",
                    "Decorative Axe", "Engraved Hatchet", "Etched Hatchet", "Infernal Axe", "Jade Hatchet", "Jasper Axe", "Karui Axe",
                    "Reaver Axe", "Royal Axe", "Runic Hatchet", "Rusted Hatchet", "Siege Axe", "Spectral Axe", "Tomahawk", "Vaal Hatchet",
                    "War Axe", "Wraith Axe", "Wrist Chopper"

            }),
    OneHandMace("One Hand Mace", new String[] {

            "Ancestral Club", "Auric Mace", "Barbed Club", "Battle Hammer", "Behemoth Mace", "Bladed Mace", "Ceremonial Mace",
            "Dragon Mace", "Dream Mace", "Driftwood Club", "Flanged Mace", "Gavel", "Legion Hammer", "Nightmare Mace", "Ornate Mace",
            "Pernarch", "Petrified Club", "Phantom Mace", "Rock Breaker", "Spiked Club", "Stone Hammer", "Tenderizer", "Tribal Club",
            "War Hammer", "Wyrm Mace"

    }),
    OneHandSword("One Hand Sword", new String[] {

            "Ancient Sword", "Antique Rapier", "Apex Rapier", "Baselard", "Basket Rapier", "Battered Foil", "Battle Sword", "Broad Sword",
            "Burnished Foil", "Copper Sword", "Corsair Sword", "Courtesan Sword", "Cutlass", "Dragonbone Rapier", "Dragoon Sword",
            "Dusk Blade", "Elder Sword", "Elegant Foil", "Elegant Sword", "Estoc", "Eternal Sword", "Fancy Foil", "Gemstone Sword",
            "Gladius", "Graceful Sword", "Grappler", "Harpy Rapier", "Hook Sword", "Jagged Foil", "Jewelled Foil", "Legion Sword",
            "Midnight Blade", "Pecoraro", "Primeval Rapier", "Rusted Spike", "Rusted Sword", "Sabre", "Serrated Foil", "Smallsword",
            "Spiraled Foil", "Tempered Foil", "Thorn Rapier", "Tiger Hook", "Twilight Blade", "Vaal Blade", "Vaal Rapier",
            "Variscite Blade", "War Sword", "Whalebone Rapier", "Wyrmbone Rapier"

    }),
    Sceptre("Sceptre",
            new String[] { "Abyssal Sceptre", "Blood Sceptre", "Bronze Sceptre", "Carnal Sceptre", "Crystal Sceptre", "Darkwood Sceptre",
                    "Driftwood Sceptre", "Grinning Fetish", "Horned Sceptre", "Iron Sceptre", "Karui Sceptre", "Lead Sceptre",
                    "Ochre Sceptre", "Opal Sceptre", "Platinum Sceptre", "Quartz Sceptre", "Ritual Sceptre", "Royal Sceptre",
                    "Sambar Sceptre", "Sekhem", "Shadow Sceptre", "Stag Sceptre", "Tyrant's Sekhem", "Vaal Sceptre", "Void Sceptre"

            }),
    Staff("Staff", new String[] {

            "Coiled Staff", "Crescent Staff", "Eclipse Staff", "Ezomyte Staff", "Foul Staff", "Gnarled Branch", "Highborn Staff",
            "Imperial Staff", "Iron Staff", "Judgement Staff", "Lathi", "Long Staff", "Maelström Staff", "Military Staff", "Moon Staff",
            "Primitive Staff", "Primordial Staff", "Quarterstaff", "Royal Staff", "Serpentine Staff", "Vile Staff", "Woodful Staff" }),
    TwoHandAxe("Two Hand Axe", new String[] {

            "Abyssal Axe", "Dagger Axe", "Despot Axe", "Double Axe", "Ezomyte Axe", "Fleshripper", "Gilded Axe", "Headsman Axe",
            "Jade Chopper", "Jasper Chopper", "Karui Chopper", "Labrys", "Noble Axe", "Poleaxe", "Shadow Axe", "Stone Axe", "Sundering Axe",
            "Talon Axe", "Timber Axe", "Vaal Axe", "Void Axe", "Woodsplitter"

    }),
    TwoHandMace("Two Hand Mace", new String[] {

            "Brass Maul", "Colossus Mallet", "Coronal Maul", "Dread Maul", "Driftwood Maul", "Fright Maul", "Great Mallet", "Imperial Maul",
            "Jagged Maul", "Karui Maul", "Mallet", "Meatgrinder", "Morning Star", "Piledriver", "Plated Maul", "Sledgehammer", "Solar Maul",
            "Spiny Maul", "Steelhead", "Terror Maul", "Totemic Maul", "Tribal Maul"

    }),
    TwoHandSword("Two Hand Sword", new String[] {

            "Bastard Sword", "Butcher Sword", "Corroded Blade", "Curved Blade", "Engraved Greatsword", "Etched Greatsword",
            "Exquisite Blade", "Ezomyte Blade", "Footman Sword", "Headman's Sword", "Highland Blade", "Infernal Sword", "Lion Sword",
            "Lithe Blade", "Longsword", "Ornate Sword", "Reaver Sword", "Spectral Sword", "Tiger Sword", "Two-Handed Sword",
            "Vaal Greatsword", "Wraith Sword"

    }),
    Wand("Wand", new String[] {

            "Carved Wand", "Crystal Wand", "Demon's Horn", "Driftwood Wand", "Engraved Wand", "Faun's Horn", "Goat's Horn", "Heathen Wand",
            "Imbued Wand", "Omen Wand", "Opal Wand", "Pagan Wand", "Profane Wand", "Prophecy Wand", "Quartz Wand", "Sage Wand",
            "Serpent Wand", "Spiraled Wand", "Tornado Wand" }),
    BodyArmour("Body Armour", new String[] {

            "Arena Plate", "Assassin's Garb", "Astral Plate", "Battle Lamellar", "Battle Plate", "Blood Raiment", "Bone Armour",
            "Bronze Plate", "Buckskin Tunic", "Cabalist Regalia", "Carnal Armour", "Chain Hauberk", "Chainmail Doublet", "Chainmail Tunic",
            "Chainmail Vest", "Chestplate", "Colosseum Plate", "Commander's Brigandine", "Conjurer's Vestment", "Conquest Chainmail",
            "Copper Plate", "Coronal Leather", "Crimson Raiment", "Crusader Chainmail", "Crusader Plate", "Crypt Armour",
            "Cutthroat's Garb", "Desert Brigandine", "Destiny Leather", "Destroyer Regalia", "Devout Chainmail", "Dragonscale Doublet",
            "Eelskin Tunic", "Elegant Ringmail", "Exquisite Leather", "Field Lamellar", "Frontier Leather", "Full Chainmail",
            "Full Dragonscale", "Full Leather", "Full Plate", "Full Ringmail", "Full Scale Armour", "Full Wyrmscale",
            "General's Brigandine", "Gladiator Plate", "Glorious Leather", "Glorious Plate", "Golden Mantle", "Golden Plate",
            "Holy Chainmail", "Hussar Brigandine", "Infantry Brigandine", "Lacquered Garb", "Latticed Ringmail", "Light Brigandine",
            "Lordly Plate", "Loricated Ringmail", "Mage's Vestment", "Majestic Plate", "Necromancer Silks", "Occultist's Vestment",
            "Oiled Coat", "Oiled Vest", "Ornate Ringmail", "Padded Jacket", "Padded Vest", "Plate Vest", "Quilted Jacket", "Ringmail Coat",
            "Sacrificial Garb", "Sadist Garb", "Sage's Robe", "Saint's Hauberk", "Saintly Chainmail", "Savant's Robe", "Scale Doublet",
            "Scale Vest", "Scarlet Raiment", "Scholar's Robe", "Sentinel Jacket", "Shabby Jerkin", "Sharkskin Tunic", "Silk Robe",
            "Silken Garb", "Silken Vest", "Silken Wrap", "Simple Robe", "Sleek Coat", "Soldier's Brigandine", "Spidersilk Robe",
            "Strapped Leather", "Sun Leather", "Sun Plate", "Thief's Garb", "Triumphant Lamellar", "Vaal Regalia", "Varnished Coat",
            "War Plate", "Waxed Garb", "Widowsilk Robe", "Wild Leather", "Wyrmscale Doublet", "Zodiac Leather" }),
    Boots("Boots", new String[] {

            "Ambush Boots", "Ancient Greaves", "Antique Greaves", "Arcanist Slippers", "Assassin's Boots", "Bronzescale Boots",
            "Carnal Boots", "Chain Boots", "Clasped Boots", "Conjurer Boots", "Crusader Boots", "Deerskin Boots", "Dragonscale Boots",
            "Eelskin Boots", "Goathide Boots", "Golden Caligae", "Goliath Greaves", "Hydrascale Boots", "Iron Greaves", "Ironscale Boots",
            "Leatherscale Boots", "Legion Boots", "Mesh Boots", "Murder Boots", "Nubuck Boots", "Plated Greaves", "Rawhide Boots",
            "Reinforced Greaves", "Ringmail Boots", "Riveted Boots", "Samite Slippers", "Satin Slippers", "Scholar Boots",
            "Serpentscale Boots", "Shackled Boots", "Shagreen Boots", "Sharkskin Boots", "Silk Slippers", "Slink Boots", "Soldier Boots",
            "Sorcerer Boots", "Stealth Boots", "Steel Greaves", "Steelscale Boots", "Strapped Boots", "Titan Greaves", "Trapper Boots",
            "Vaal Greaves", "Velvet Slippers", "Wool Shoes", "Wrapped Boots", "Wyrmscale Boots", "Zealot Boots"

    }),
    Gloves("Gloves", new String[] {

            "Ambush Mitts", "Ancient Gauntlets", "Antique Gauntlets", "Arcanist Gloves", "Assassin's Mitts", "Bronze Gauntlets",
            "Bronzescale Gauntlets", "Carnal Mitts", "Chain Gloves", "Clasped Mitts", "Conjurer Gloves", "Crusader Gloves",
            "Deerskin Gloves", "Dragonscale Gauntlets", "Eelskin Gloves", "Embroidered Gloves", "Fishscale Gauntlets", "Goathide Gloves",
            "Golden Bracers", "Goliath Gauntlets", "Hydrascale Gauntlets", "Iron Gauntlets", "Ironscale Gauntlets", "Legion Gloves",
            "Mesh Gloves", "Murder Mitts", "Nubuck Gloves", "Plated Gauntlets", "Rawhide Gloves", "Ringmail Gloves", "Riveted Gloves",
            "Samite Gloves", "Satin Gloves", "Serpentscale Gauntlets", "Shagreen Gloves", "Sharkskin Gloves", "Silk Gloves", "Slink Gloves",
            "Soldier Gloves", "Sorcerer Gloves", "Stealth Gloves", "Steel Gauntlets", "Steelscale Gauntlets", "Strapped Mitts",
            "Titan Gauntlets", "Trapper Mitts", "Vaal Gauntlets", "Velvet Gloves", "Wool Gloves", "Wrapped Mitts", "Wyrmscale Gauntlets",
            "Zealot Gloves"

    }),
    Helmet("Helmet", new String[] {

            "Aventail Helmet", "Barbute Helmet", "Battered Helm", "Bone Circlet", "Callous Mask", "Close Helmet", "Cone Helmet",
            "Crusader Helmet", "Deicide Mask", "Eternal Burgonet", "Ezomyte Burgonet", "Fencer Helm", "Festival Mask", "Fluted Bascinet",
            "Gilded Sallet", "Gladiator Helmet", "Golden Mask", "Golden Wreath", "Great Crown", "Great Helmet", "Harlequin Mask",
            "Hubris Circlet", "Hunter Hood", "Iron Circlet", "Iron Hat", "Iron Mask", "Lacquered Helmet", "Leather Cap", "Leather Hood",
            "Lion Pelt", "Lunaris Circlet", "Magistrate Crown", "Mind Cage", "Necromancer Circlet", "Nightmare Bascinet", "Noble Tricorne",
            "Pig-Faced Bascinet", "Plague Mask", "Praetor Crown", "Prophet Crown", "Raven Mask", "Reaver Helmet", "Regicide Mask",
            "Royal Burgonet", "Rusted Coif", "Sallet", "Samite Helmet", "Scare Mask", "Secutor Helm", "Siege Helmet", "Silken Hood",
            "Sinner Tricorne", "Solaris Circlet", "Soldier Helmet", "Steel Circlet", "Torture Cage", "Tribal Circlet", "Tricorne",
            "Ursine Pelt", "Vaal Mask", "Vine Circlet", "Visored Sallet", "Wolf Pelt", "Zealot Helmet"

    }),
    Shield("Shield", new String[] {

            "Alder Spiked Shield", "Alloyed Spiked Shield", "Ancient Spirit Shield", "Angelic Kite Shield", "Archon Kite Shield",
            "Baroque Round Shield", "Battle Buckler", "Bone Spirit Shield", "Branded Kite Shield", "Brass Spirit Shield",
            "Bronze Tower Shield", "Buckskin Tower Shield", "Burnished Spiked Shield", "Cardinal Round Shield", "Cedar Tower Shield",
            "Ceremonial Kite Shield", "Champion Kite Shield", "Chiming Spirit Shield", "Colossal Tower Shield", "Compound Spiked Shield",
            "Copper Tower Shield", "Corroded Tower Shield", "Corrugated Buckler", "Crested Tower Shield", "Crimson Round Shield",
            "Crusader Buckler", "Driftwood Spiked Shield", "Ebony Tower Shield", "Elegant Round Shield", "Enameled Buckler",
            "Etched Kite Shield", "Ezomyte Spiked Shield", "Ezomyte Tower Shield", "Fir Round Shield", "Fossilised Spirit Shield",
            "Gilded Buckler", "Girded Tower Shield", "Goathide Buckler", "Golden Buckler", "Hammered Buckler", "Harmonic Spirit Shield",
            "Imperial Buckler", "Ironwood Buckler", "Ivory Spirit Shield", "Jingling Spirit Shield", "Lacewood Spirit Shield",
            "Lacquered Buckler", "Laminated Kite Shield", "Layered Kite Shield", "Linden Kite Shield", "Mahogany Tower Shield",
            "Maple Round Shield", "Mirrored Spiked Shield", "Mosaic Kite Shield", "Oak Buckler", "Ornate Spiked Shield", "Painted Buckler",
            "Painted Tower Shield", "Pine Buckler", "Pinnacle Tower Shield", "Plank Kite Shield", "Polished Spiked Shield",
            "Rawhide Tower Shield", "Redwood Spiked Shield", "Reinforced Kite Shield", "Reinforced Tower Shield", "Rotted Round Shield",
            "Scarlet Round Shield", "Shagreen Tower Shield", "Sovereign Spiked Shield", "Spiked Bundle", "Spiked Round Shield",
            "Spiny Round Shield", "Splendid Round Shield", "Splintered Tower Shield", "Steel Kite Shield", "Studded Round Shield",
            "Supreme Spiked Shield", "Tarnished Spirit Shield", "Teak Round Shield", "Thorium Spirit Shield", "Titanium Spirit Shield",
            "Twig Spirit Shield", "Vaal Buckler", "Vaal Spirit Shield", "Walnut Spirit Shield", "War Buckler", "Yew Spirit Shield"

    }),
    Amulet("Amulet", new String[] {

            "Agate Amulet", "Amber Amulet", "Ashscale Talisman", "Avian Twins Talisman", "Black Maw Talisman", "Bonespire Talisman",
            "Breakrib Talisman", "Chrysalis Talisman", "Citrine Amulet", "Clutching Talisman", "Coral Amulet", "Deadhand Talisman",
            "Deep One Talisman", "Fangjaw Talisman", "Gold Amulet", "Greatwolf Talisman", "Hexclaw Talisman", "Horned Talisman",
            "Jade Amulet", "Jet Amulet", "Jet Amulet", "Lapis Amulet", "Lone Antler Talisman", "Longtooth Talisman", "Mandible Talisman",
            "Monkey Paw Talisman", "Monkey Twins Talisman", "Onyx Amulet", "Paua Amulet", "Primal Skull Talisman", "Rot Head Talisman",
            "Rotfeather Talisman", "Spinefuse Talisman", "Splitnewt Talisman", "Three Hands Talisman", "Three Rat Talisman",
            "Turquoise Amulet", "Undying Flesh Talisman", "Wereclaw Talisman", "Writhing Talisman"

    }),
    Belt("Belt", new String[] {

            "Chain Belt", "Cloth Belt", "Golden Obi", "Heavy Belt", "Leather Belt", "Rustic Sash", "Studded Belt"

    }),
    DivinationCard("Divination Card", new String[] {

            "A Mother's Parting Gift", "Abandoned Wealth", "Anarchy's Price", "Assassin's Favour", "Audacity", "Birth of the Three",
            "Blind Venture", "Bowyer's Dream", "Chaotic Disposition", "Coveted Possession", "Death", "Doedre's Madness", "Earth Drinker",
            "Emperor's Luck", "Gemcutter's Promise", "Gift of the Gemling Queen", "Glimmer of Hope", "Grave Knowledge", "Her Mask", "Hope",
            "House of Mirrors", "Hubris", "Humility", "Hunter's Resolve", "Hunter's Reward", "Jack in the Box", "Lantador's Lost Love",
            "Last Hope", "Lost Worlds", "Loyalty", "Lucky Connections", "Merciless Armament", "Pride Before the Fall", "Prosperity",
            "Rain of Chaos", "Rats", "Scholar of the Seas", "The Aesthete", "The Arena Champion", "The Artist", "The Avenger",
            "The Battle Born", "The Betrayal", "The Body", "The Brittle Emperor", "The Carrion Crow", "The Cartographer", "The Cataclysm",
            "The Catalyst", "The Celestial Justicar", "The Chains that Bind", "The Conduit", "The Dapper Prodigy", "The Dark Mage",
            "The Demoness", "The Doctor", "The Doppelganger", "The Dragon", "The Dragon's Heart", "The Drunken Aristocrat",
            "The Encroaching Darkness", "The Enlightened", "The Ethereal", "The Explorer", "The Feast", "The Fiend", "The Fletcher",
            "The Flora's Gift", "The Fox", "The Gambler", "The Gemcutter", "The Gentleman", "The Gladiator", "The Hermit", "The Hoarder",
            "The Hunger", "The Incantation", "The Inoculated", "The Inventor", "The King's Blade", "The King's Heart",
            "The Last One Standing", "The Lich", "The Lion", "The Lord in Black", "The Lover", "The Mercenary", "The Metalsmith's Gift",
            "The Offering", "The One With All", "The Pack Leader", "The Pact", "The Poet", "The Queen", "The Rabid Rhoa", "The Risk",
            "The Road to Power", "The Scarred Meadow", "The Scholar", "The Sigil", "The Siren", "The Spoiled Prince", "The Summoner",
            "The Sun", "The Surgeon", "The Surveyor", "The Survivalist", "The Thaumaturgist", "The Tower", "The Traitor", "The Trial",
            "The Twins", "The Union", "The Vast", "The Warden", "The Warlord", "The Watcher", "The Wind", "The Wolf's Shadow", "The Wrath",
            "Three Faces in the Dark", "Time-Lost Relic", "Tranquillity", "Treasure Hunter", "Turn the Other Cheek", "Vinia's Token",
            "Volatile Power", "Wealth and Power"

    }),

    Flask("Flask", new String[] {

            "Amethyst Flask", "Aquamarine Flask", "Basalt Flask", "Bismuth Flask", "Colossal Hybrid Flask", "Colossal Life Flask",
            "Colossal Mana Flask", "Diamond Flask", "Divine Life Flask", "Divine Mana Flask", "Eternal Life Flask", "Eternal Mana Flask",
            "Giant Life Flask", "Giant Mana Flask", "Grand Life Flask", "Grand Mana Flask", "Granite Flask", "Greater Life Flask",
            "Greater Mana Flask", "Hallowed Hybrid Flask", "Hallowed Life Flask", "Hallowed Mana Flask", "Jade Flask", "Large Hybrid Flask",
            "Large Life Flask", "Large Mana Flask", "Medium Hybrid Flask", "Medium Life Flask", "Medium Mana Flask", "Quartz Flask",
            "Quicksilver Flask", "Ruby Flask", "Sacred Hybrid Flask", "Sacred Life Flask", "Sacred Mana Flask", "Sanctified Life Flask",
            "Sanctified Mana Flask", "Sapphire Flask", "Silver Flask", "Small Hybrid Flask", "Small Life Flask", "Small Mana Flask",
            "Stibnite Flask", "Sulphur Flask", "Topaz Flask"

    }),
    Gem("Gem", new String[] { "Abyssal Cry", "Added Chaos Damage", "Added Cold Damage", "Added Fire Damage", "Added Lightning Damage",
            "Additional Accuracy", "Ancestral Protector", "Anger", "Animate Guardian", "Animate Weapon", "Arc", "Arctic Armour",
            "Arctic Breath", "Assassin's Mark", "Ball Lightning", "Ball Lightning", "Barrage", "Bear Trap", "Blade Vortex", "Bladefall",
            "Blasphemy", "Blast Rain", "Blind", "Blink Arrow", "Block Chance Reduction", "Blood Magic", "Blood Rage", "Bloodlust",
            "Bone Offering", "Burning Arrow", "Cast On Critical Strike", "Cast on Death", "Cast on Melee Kill", "Cast when Damage Taken",
            "Cast when Stunned", "Caustic Arrow", "Chain", "Chance to Flee", "Chance to Ignite", "Clarity", "Cleave", "Cluster Traps",
            "Cold Penetration", "Cold Snap", "Cold to Fire", "Concentrated Effect", "Conductivity", "Contagion", "Controlled Destruction",
            "Conversion Trap", "Convocation", "Culling Strike", "Curse On Hit", "Cyclone", "Decoy Totem", "Desecrate", "Determination",
            "Detonate Dead", "Detonate Mines", "Devouring Totem", "Discharge", "Discipline", "Dominating Blow", "Double Strike",
            "Dual Strike", "Earthquake", "Elemental Focus", "Elemental Hit", "Elemental Proliferation", "Elemental Weakness", "Empower",
            "Endurance Charge on Melee Stun", "Enduring Cry", "Enfeeble", "Enhance", "Enlighten", "Essence Drain", "Ethereal Knives",
            "Explosive Arrow", "Faster Attacks", "Faster Casting", "Faster Projectiles", "Fire Nova Mine", "Fire Penetration", "Fire Trap",
            "Fireball", "Firestorm", "Flame Dash", "Flame Surge", "Flame Totem", "Flameblast", "Flammability", "Flesh Offering",
            "Flicker Strike", "Fork", "Fortify", "Freeze Mine", "Freezing Pulse", "Frenzy", "Frost Blades", "Frost Bomb", "Frost Wall",
            "Frostbite", "Generosity", "Glacial Cascade", "Glacial Hammer", "Grace", "Greater Multiple Projectiles", "Ground Slam", "Haste",
            "Hatred", "Heavy Strike", "Herald of Ash", "Herald of Ice", "Herald of Thunder", "Hypothermia", "Ice Bite", "Ice Crash",
            "Ice Nova", "Ice Shot", "Ice Spear", "Ice Trap", "Immortal Call", "Incinerate", "Increased Area of Effect",
            "Increased Burning Damage", "Increased Critical Damage", "Increased Critical Strikes", "Increased Duration", "Infernal Blow",
            "Innervate", "Iron Grip", "Iron Will", "Item Quantity", "Item Rarity", "Kinetic Blast", "Knockback", "Leap Slam",
            "Less Duration", "Lesser Multiple Projectiles", "Life Gain on Hit", "Life Leech", "Lightning Arrow", "Lightning Penetration",
            "Lightning Strike", "Lightning Tendrils", "Lightning Trap", "Lightning Warp", "Magma Orb", "Mana Leech",
            "Melee Damage on Full Life", "Melee Physical Damage", "Melee Splash", "Minefield", "Minion Damage", "Minion Life",
            "Minion Speed", "Minion and Totem Elemental Resistance", "Mirror Arrow", "Molten Shell", "Molten Strike", "Multiple Traps",
            "Multistrike", "Orb of Storms", "Phase Run", "Physical Projectile Attack Damage", "Physical to Lightning", "Pierce",
            "Poacher's Mark", "Point Blank", "Poison", "Portal", "Power Charge On Critical", "Power Siphon", "Projectile Weakness",
            "Puncture", "Punishment", "Purity of Elements", "Purity of Fire", "Purity of Ice", "Purity of Lightning", "Rain of Arrows",
            "Raise Spectre", "Raise Zombie", "Rallying Cry", "Ranged Attack Totem", "Rapid Decay", "Reave", "Reckoning", "Reduced Mana",
            "Rejuvenation Totem", "Remote Mine", "Righteous Fire", "Riposte", "Searing Bond", "Shield Charge", "Shock Nova",
            "Shockwave Totem", "Shrapnel Shot", "Siege Ballista", "Slower Projectiles", "Smoke Mine", "Spark", "Spectral Throw",
            "Spell Echo", "Spell Totem", "Split Arrow", "Static Strike", "Storm Call", "Stun", "Summon Chaos Golem", "Summon Flame Golem",
            "Summon Ice Golem", "Summon Lightning Golem", "Summon Raging Spirit", "Summon Skeletons", "Summon Stone Golem", "Sunder",
            "Sweep", "Tempest Shield", "Temporal Chains", "Tornado Shot", "Trap", "Trap Cooldown", "Trap and Mine Damage", "Vaal Arc",
            "Vaal Burning Arrow", "Vaal Clarity", "Vaal Cold Snap", "Vaal Cyclone", "Vaal Detonate Dead", "Vaal Discipline",
            "Vaal Double Strike", "Vaal Fireball", "Vaal Flameblast", "Vaal Glacial Hammer", "Vaal Grace", "Vaal Ground Slam", "Vaal Haste",
            "Vaal Ice Nova", "Vaal Immortal Call", "Vaal Lightning Strike", "Vaal Lightning Trap", "Vaal Lightning Warp",
            "Vaal Molten Shell", "Vaal Power Siphon", "Vaal Rain of Arrows", "Vaal Reave", "Vaal Righteous Fire", "Vaal Spark",
            "Vaal Spectral Throw", "Vaal Storm Call", "Vaal Summon Skeletons", "Vengeance", "Vigilant Strike", "Viper Strike", "Vitality",
            "Void Manipulation", "Vulnerability", "Warlord's Mark", "Weapon Elemental Damage", "Whirling Blades", "Wild Strike", "Wither",
            "Wrath"

    }),
    Jewel("Jewel", new String[] {
            "Cobalt Jewel", "Crimson Jewel", "Viridian Jewel",

    }),
    Map("Map", new String[] {
            "Abandoned Cavern Map", "Abyss Map", "Academy Map", "Arachnid Nest Map", "Arcade Map", "Arena Map", "Arid Lake Map",
            "Arsenal Map", "Bazaar Map", "Bog Map", "Canyon Map", "Catacomb Map", "Cells Map", "Cemetery Map", "Channel Map", "Chateau Map",
            "Colonnade Map", "Colosseum Map", "Conservatory Map", "Core Map", "Courtyard Map", "Coves Map", "Crematorium Map", "Crypt Map",
            "Dark Forest Map", "Desert Map", "Dry Peninsula", "Dry Peninsula Map", "Dry Woods Map", "Dunes Map", "Dungeon Map",
            "Excavation Map", "Ghetto Map", "Gorge Map", "Graveyard Map", "Grotto Map", "Jungle Valley Map", "Malformation Map",
            "Marsh Map", "Mountain Ledge Map", "Mud Geyser Map", "Museum Map", "Necropolis Map", "Orchard Map", "Overgrown Ruin Map",
            "Overgrown Shrine Map", "Palace Map", "Phantasmagoria Map", "Pier Map", "Pit Map", "Plateau Map", "Precinct Map",
            "Promenade Map", "Quarry Map", "Reef Map", "Residence Map", "Sewer Map", "Shipyard Map", "Shore Map", "Shrine Map",
            "Spider Forest Map", "Spider Lair Map", "Springs Map", "Strand Map", "Subterranean Stream Map", "Temple Map", "Terrace Map",
            "Thicket Map", "Tomb Map", "Torture Chamber Map", "Tropical Island Map", "Tunnel Map", "Underground River Map",
            "Underground Sea Map", "Vaal Pyramid Map", "Vaal Temple Map", "Villa Map", "Village Ruin Map", "Volcano Map", "Waste Pool Map",
            "Wasteland Map", "Waterways Map", "Wharf Map"

    }),
    Quiver("Quiver", new String[] {
            "Blunt Arrow Quiver", "Broadhead Arrow Quiver", "Conductive Quiver", "Cured Quiver", "Fire Arrow Quiver", "Heavy Quiver",
            "Light Quiver", "Penetrating Arrow Quiver", "Rugged Quiver", "Serrated Arrow Quiver", "Sharktooth Arrow Quiver",
            "Spike-Point Arrow Quiver", "Two-Point Arrow Quiver"

    }),
    Ring("Ring", new String[] {
            "Amethyst Ring", "Coral Ring", "Diamond Ring", "Gold Ring", "Golden Hoop", "Iron Ring", "Moonstone Ring", "Paua Ring",
            "Prismatic Ring", "Ruby Ring", "Sapphire Ring", "Topaz Ring", "Two-Stone Ring", "Unset Ring"

    }),
    VaalFragments("Vaal Fragments", new String[] {
            "Mortal Grief", "Mortal Hope", "Mortal Ignorance", "Mortal Rage", "Sacrifice at Dawn", "Sacrifice at Dusk",
            "Sacrifice at Midnight", "Sacrifice at Noon"

    });

    private String type;
    private String[] base;

    TypeBaseUtil(String type, String[] base) {
        this.type = type;
        this.base = base;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getBase() {
        return base;
    }

    public void setBase(String[] base) {
        this.base = base;
    }

    public static Optional<String> getTypeForItem(String base){

        return Arrays.asList(values()).stream()
                .filter(e ->
                        Arrays.asList(e.getBase()).contains(base))
                .findFirst()
                .map(t -> t.getType());
    }
}
